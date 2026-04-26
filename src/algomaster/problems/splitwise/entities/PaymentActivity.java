package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class PaymentActivity {
    private final String id;
    protected final User payer;
    protected final BigDecimal amount;

    public User getPayer() {
        return payer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public PaymentActivity(User payer, BigDecimal amount) {
        this.id = UUID.randomUUID().toString();
        this.payer = payer;
        this.amount = amount;
    }

}
