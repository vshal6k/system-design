package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.splitwise.splitstrategy.SplitStrategy;

public class Expense extends PaymentActivity {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final SplitStrategy splitStrategy;

    public Expense(BigDecimal amount, User paidBy, List<User> users, SplitStrategy splitStrategy) {
        super(paidBy, amount);
        addUsers(users);
        this.splitStrategy = splitStrategy;
    }

    private void addUsers(List<User> users) {
        for (User user : users) {
            this.users.put(user.getUserId(), user);
        }
    }

    public Map<String, BigDecimal> split() {
        return splitStrategy.split(amount, new ArrayList<>(users.values()));
    }

    public boolean isRelevant(User user) {
        if (users.get(user.getUserId()) != null)
            return true;
        return false;
    }

}
