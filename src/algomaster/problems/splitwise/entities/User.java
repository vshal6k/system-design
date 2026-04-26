package algomaster.problems.splitwise.entities;

import java.util.UUID;

public class User {
    private final String userId;
    private final String name;
    private final String email;
    private final String phone;
    private final BalanceSheet balanceSheet;

    public User(String name, String email, String phone) {
        // Add validations if required
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balanceSheet = new BalanceSheet(this);
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

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public String getPhone() {
        return phone;
    }

}
