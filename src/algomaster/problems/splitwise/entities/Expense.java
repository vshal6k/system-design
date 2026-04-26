package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import algomaster.problems.splitwise.splitstrategy.SplitStrategy;

public class Expense extends PaymentActivity {
    private final List<User> users;
    private final SplitStrategy splitStrategy;

    public Expense(BigDecimal amount, User paidBy, List<User> users, SplitStrategy splitStrategy) {
        super(paidBy, amount);
        this.users = users;
        this.splitStrategy = splitStrategy;
    }

    public Expense negation() {
        return new Expense(super.amount.negate(), super.payer, users, splitStrategy);
    }

    public Map<String, BigDecimal> split() {
        return splitStrategy.split(amount, users);
    }

}
