package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {
    private final String id;
    private final User payer;
    private final User payee;
    private final BigDecimal amount;

    public Transaction(User payer, User payee, BigDecimal amount) {
        // Add validations if required
        this.id = UUID.randomUUID().toString();
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public User getPayer() {
        return payer;
    }

    public User getPayee() {
        return payee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
