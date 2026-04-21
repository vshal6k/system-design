package algomaster.problems.atm.domainmodel;

import java.math.BigDecimal;

public class Account {
    private final String number;
    private BigDecimal balance;

    public Account(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println("Account: Deposit " + amount + " in " + number);
    }

    public boolean withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            return false;
        }
        balance = balance.subtract(amount);
        System.out.println("Account: Withdraw " + amount + " from " + number);
        return true;
    }

}
