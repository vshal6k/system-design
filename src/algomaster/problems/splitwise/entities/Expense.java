package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.splitwise.splitstrategy.SplitStrategy;

public class Expense {
    private final String expenseId;
    private final String description;
    private final User paidBy;
    private final BigDecimal amount;
    private final SplitStrategy splitStrategy;
    private final Map<String, User> participants;
    private final List<Split> splits;

    private Expense(ExpenseBuilder builder) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = builder.description;
        this.paidBy = builder.paidBy;
        this.amount = builder.amount;
        this.splitStrategy = builder.splitStrategy;
        this.participants = builder.participants;
        this.splits = splitStrategy.split(amount, List.copyOf(participants.values()));
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public List<User> getParticipants() {
        return new ArrayList<>(participants.values());
    }

    public List<Split> getSplits() {
        return splits;
    }

    // Builder Design Pattern
    public static class ExpenseBuilder {
        private String expenseId;
        private User paidBy;
        private BigDecimal amount;
        private String description;
        private SplitStrategy splitStrategy;
        private Map<String, User> participants = new ConcurrentHashMap<>();

        public ExpenseBuilder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public ExpenseBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ExpenseBuilder setSplitStrategy(SplitStrategy splitStrategy) {
            this.splitStrategy = splitStrategy;
            return this;
        }

        public ExpenseBuilder setParticipants(List<User> participants) {
            participants.stream().forEach(participant -> this.participants.put(participant.getUserId(), participant));
            return this;
        }

        public Expense build() {
            if (paidBy == null)
                throw new IllegalArgumentException("Paid by cannot be null for expenses.");
            if (amount == null)
                throw new IllegalArgumentException("Amount cannot be null for expenses.");
            if (splitStrategy == null)
                throw new IllegalArgumentException("Split strategy cannot be null for expenses.");
            if (participants == null || participants.isEmpty())
                throw new IllegalArgumentException("Expenses should have at least one participant.");

            return new Expense(this);

        }

    }

}
