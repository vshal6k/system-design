package algomaster.problems.splitwise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.splitwise.entities.Expense;
import algomaster.problems.splitwise.entities.Group;
import algomaster.problems.splitwise.entities.PaymentActivity;
import algomaster.problems.splitwise.entities.Settlement;
import algomaster.problems.splitwise.entities.User;
import algomaster.problems.splitwise.splitstrategy.SplitStrategy;

public class SplitwiseSystem {
    private final BalanceRegistry balanceRegistry = new BalanceRegistry();
    private final Map<String, Group> groups = new ConcurrentHashMap<>();
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final List<PaymentActivity> activities = Collections.synchronizedList(new ArrayList<>());

    public User addUser(String name, String email, String phone) {
        User user = new User(name, email, phone);
        users.put(user.getUserId(), user);
        return user;
    }

    public Group createGroup(String groupName, List<User> users) {
        Group group = new Group(groupName, users);
        groups.put(group.getGroupId(), group);
        return group;
    }

    public Expense addExpense(User paidBy, Group group, BigDecimal amount, SplitStrategy splitStrategy) {
        Expense expense = new Expense(amount, paidBy, group.getUsers(), splitStrategy);
        balanceRegistry.onExpenseAddition(expense);
        activities.add(expense);
        return expense;
    }

    public void settlePartial(User payer, User receiver, BigDecimal amount) {
        Settlement settlement = new Settlement(payer, receiver, amount);
        balanceRegistry.onSettlement(settlement);
        activities.add(settlement);
    }

    // Used by payer to settle the amount owed to the receiver
    public void settleFull(User payer, User receiver) {
        Map<String, BigDecimal> payerOwedMap = balanceRegistry.getBalance(payer);
        if (payerOwedMap == null || payerOwedMap.size() == 0)
            throw new IllegalArgumentException("Payer does not owe any amount to settle");

        BigDecimal amountOwedToReceiver = payerOwedMap.get(receiver.getUserId());

        if (amountOwedToReceiver == null || amountOwedToReceiver.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payer does not owe any amount to receiver to settle");
        }

        Settlement settlement = new Settlement(payer, receiver, amountOwedToReceiver);
        balanceRegistry.onSettlement(settlement);
        activities.add(settlement);
    }

    // for debugging purpose only
    public void displayAmountOwed(User user) {
        Map<String, BigDecimal> amountOwed = balanceRegistry.getBalance(user);

        if (amountOwed == null || amountOwed.size() == 0) {
            System.out.println(user.getName() + " does not owe anything.");
            return;
        }

        amountOwed.entrySet().stream().forEach(entry -> {
            System.out.println(
                    user.getName() + " owes " + entry.getValue() + " amount to " + users.get(entry.getKey()).getName());
        });
    }

}
