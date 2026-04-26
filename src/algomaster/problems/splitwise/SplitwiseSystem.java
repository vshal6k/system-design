package algomaster.problems.splitwise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import algomaster.problems.splitwise.entities.Expense;
import algomaster.problems.splitwise.entities.Group;
import algomaster.problems.splitwise.entities.PaymentActivity;
import algomaster.problems.splitwise.entities.Settlement;
import algomaster.problems.splitwise.entities.User;
import algomaster.problems.splitwise.observerpattern.ExpenseObserver;
import algomaster.problems.splitwise.observerpattern.SettlementObserver;
import algomaster.problems.splitwise.splitstrategy.EqualSplitStrategy;
import algomaster.problems.splitwise.splitstrategy.SplitStrategy;

public class SplitwiseSystem {
    private final BalanceRegistry balanceRegistry = new BalanceRegistry();
    private final Map<String, Group> groups = new ConcurrentHashMap<>();
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, PaymentActivity> activities = new ConcurrentHashMap<>();
    private List<ExpenseObserver> expenseObservers = Collections.synchronizedList(new ArrayList<>());
    private List<SettlementObserver> settlementObservers = Collections.synchronizedList(new ArrayList<>());
    private ReentrantLock settlementLock = new ReentrantLock();

    public SplitwiseSystem() {
        expenseObservers.add(balanceRegistry);
        settlementObservers.add(balanceRegistry);
    }

    public User addUser(String name, String email, String phone) {
        User user = new User(name, email, phone);
        users.put(user.getUserId(), user);
        expenseObservers.add(user);
        settlementObservers.add(user);
        return user;
    }

    public Group createGroup(String groupName, List<User> users) {
        for (User user : users) {
            if (this.users.get(user.getUserId()) == null)
                throw new IllegalArgumentException("User is not registered in the system.");
        }

        Group group = new Group(groupName, users);
        groups.put(group.getGroupId(), group);
        return group;
    }

    public Expense addGroupExpense(User paidBy, Group group, BigDecimal amount, SplitStrategy splitStrategy) {
        try {
            settlementLock.lock();
            Expense expense = new Expense(amount, paidBy, group.getUsers(), splitStrategy);
            group.addActivity(expense);
            notifyExpenseObservers(expense);
            activities.put(expense.getId(), expense);
            return expense;
        } finally {
            settlementLock.unlock();
        }
    }

    public Expense addIndividualExpense(User paidBy, User recevier, BigDecimal amount) {
        try {
            settlementLock.lock();
            Expense expense = new Expense(amount, paidBy, List.of(recevier), new EqualSplitStrategy());
            notifyExpenseObservers(expense);
            activities.put(expense.getId(), expense);
            return expense;
        } finally {
            settlementLock.unlock();
        }
    }

    public void settlePartial(User payer, User receiver, BigDecimal amount) {
        try {
            settlementLock.lock();
            Map<String, BigDecimal> payerOwedMap = balanceRegistry.getBalance(payer);
            if (payerOwedMap == null || payerOwedMap.size() == 0)
                throw new IllegalArgumentException("Payer does not owe any amount to settle");

            BigDecimal amountOwedToReceiver = payerOwedMap.get(receiver.getUserId());

            if (amountOwedToReceiver == null || amountOwedToReceiver.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Payer does not owe any amount to receiver to settle");
            }

            Settlement settlement = new Settlement(payer, receiver, amount);
            notifySettlementObservers(settlement);
            activities.put(settlement.getId(), settlement);
        } finally {
            settlementLock.unlock();
        }
    }

    // Used by payer to settle the amount owed to the receiver
    public void settleFull(User payer, User receiver) {
        try {
            settlementLock.lock();
            Map<String, BigDecimal> payerOwedMap = balanceRegistry.getBalance(payer);
            if (payerOwedMap == null || payerOwedMap.size() == 0)
                throw new IllegalArgumentException("Payer does not owe any amount to settle");

            BigDecimal amountOwedToReceiver = payerOwedMap.get(receiver.getUserId());

            if (amountOwedToReceiver == null || amountOwedToReceiver.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Payer does not owe any amount to receiver to settle");
            }

            Settlement settlement = new Settlement(payer, receiver, amountOwedToReceiver);
            notifySettlementObservers(settlement);
            activities.put(settlement.getId(), settlement);
        } finally {
            settlementLock.unlock();
        }
    }

    public void notifyExpenseObservers(Expense expense) {
        for (ExpenseObserver expenseObserver : expenseObservers) {
            expenseObserver.onExpenseAddition(expense);
        }
    }

    public void notifySettlementObservers(Settlement settlement) {
        for (SettlementObserver settlementObserver : settlementObservers) {
            settlementObserver.onSettlement(settlement);
        }
    }

    // for debugging purpose only
    public void displayAmountOwed(User user) {
        try {
            settlementLock.lock();
            Map<String, BigDecimal> amountOwed = balanceRegistry.getBalance(user);

            if (amountOwed == null || amountOwed.size() == 0) {
                System.out.println(user.getName() + " does not owe anything.");
                return;
            }

            amountOwed.entrySet().stream().forEach(entry -> {
                System.out.println(
                        user.getName() + " owes " + entry.getValue() + " amount to "
                                + users.get(entry.getKey()).getName());
            });
        } finally {
            settlementLock.unlock();
        }

    }

}
