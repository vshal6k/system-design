package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;

public class Split {
    private final User user;
    private final BigDecimal amount;

    public User getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Split(User user, BigDecimal amount) {
        // Add validations if required
        this.user = user;
        this.amount = amount;
    }

}
