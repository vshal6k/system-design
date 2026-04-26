package algomaster.problems.splitwise.entities;

import java.util.UUID;

import algomaster.problems.splitwise.observerpattern.ExpenseObserver;
import algomaster.problems.splitwise.observerpattern.SettlementObserver;

public class User implements SettlementObserver, ExpenseObserver {
    private final String userId;
    private final String name;
    private final String email;
    private final String phone;

    public User(String name, String email, String phone) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void onExpenseAddition(Expense expense) {
        if (!expense.isRelevant(this) || expense.getPayer().getUserId().equals(userId))
            return;

        System.out.println("Hey " + name + "! " + expense.getPayer().getName() + " has added an expense of amount "
                + expense.getAmount());
    }

    @Override
    public void onSettlement(Settlement settlement) {
        if (!settlement.getReceiver().userId.equals(userId))
            return;

        System.out.println("Hey " + name + "! " + settlement.getPayer().getName() + " has settled "
                + settlement.getAmount() + " with you.");

    }

}
