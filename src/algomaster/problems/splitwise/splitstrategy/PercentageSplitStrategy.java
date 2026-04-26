package algomaster.problems.splitwise.splitstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algomaster.problems.splitwise.entities.User;

public class PercentageSplitStrategy implements SplitStrategy {

    private final Map<String, BigDecimal> userPercentMap;

    public PercentageSplitStrategy(Map<String, BigDecimal> userPercentMap) {
        BigDecimal percentSum = userPercentMap.values().stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        if (BigDecimal.ONE.compareTo(percentSum) != 0)
            throw new IllegalArgumentException("Sum of percentages is not equal to one.");

        this.userPercentMap = userPercentMap;
    }

    @Override
    public Map<String, BigDecimal> split(BigDecimal amount, List<User> users) {
        if (amount == null)
            throw new IllegalArgumentException("Amount cannot be null");
        if (users == null)
            throw new IllegalArgumentException("Users cannot be null");

        Map<String, BigDecimal> amounts = new HashMap<>();
        int totalUsers = users.size();

        if (BigDecimal.ZERO.equals(amount) || totalUsers == 0) {
            // amount zero or no users does not require any splitting
            return amounts;
        }

        for (User user : users) {
            BigDecimal percentage = userPercentMap.get(user.getUserId());

            if (percentage == null)
                throw new IllegalArgumentException("No percentage data found for the user " + user.getName());

            amounts.put(user.getUserId(), amount.multiply(percentage));

        }

        return amounts;
    }

}
