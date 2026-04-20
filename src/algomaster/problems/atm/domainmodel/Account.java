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
        if (amount == null)
            return;

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null)
            return;
        if (balance.compareTo(amount) >= 0)
            balance = balance.subtract(amount);
    }

}
