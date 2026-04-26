package algomaster.problems.splitwise.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.splitwise.observerpattern.ExpenseObserver;
import algomaster.problems.splitwise.observerpattern.SettlementObserver;

public class Group {
    private final String groupId;
    private final String groupName;
    private Map<String, Expense> expenses = new ConcurrentHashMap<>();
    private Map<String, User> users = new ConcurrentHashMap<>();
    private List<ExpenseObserver> expenseObservers = new ArrayList<>();
    private List<SettlementObserver> settlementObservers = new ArrayList<>();

    public Group(String groupName, List<User> users) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        addUsers(users);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public String getGroupId() {
        return groupId;
    }

    public void addUsers(List<User> users) {
        for (User user : users) {
            this.users.put(user.getUserId(), user);
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public void addUser(User user) {
        if (users.get(user.getUserId()) != null)
            throw new IllegalArgumentException("User is already a part of the group.");

        users.put(user.getUserId(), user);
    }

    public void removeUser(User user) {
        if (users.get(user.getUserId()) == null)
            throw new IllegalArgumentException("User is not a part of the group.");

        users.remove(user.getUserId());
    }

    public void addExpense(Expense expense) {
        if (expenses.get(expense.getId()) != null)
            throw new IllegalArgumentException("Expense is already added in the group.");

        expenses.put(expense.getId(), expense);
        notifyExpenseObservers(expense);
    }

    public void removeExpense(Expense expense) {
        if (expenses.get(expense.getId()) == null)
            throw new IllegalArgumentException("Expense is not added in the group.");

        expenses.remove(expense.getId());
        notifyExpenseObservers(expense.negation());
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

}
