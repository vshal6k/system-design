package algomaster.problems.splitwise.splitstrategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algomaster.problems.splitwise.entities.User;

public class ExactAmountSplitStrategy implements SplitStrategy {
    private final Map<String, BigDecimal> userAmountMap;

    public ExactAmountSplitStrategy(Map<String, BigDecimal> userAmountMap) {
        this.userAmountMap = userAmountMap;
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

        validateUserAmountMap(amount);

        for (User user : users) {
            BigDecimal userAmount = userAmountMap.get(user.getUserId());

            if (userAmount == null)
                throw new IllegalArgumentException("No percentage data found for the user " + user.getName());

            amounts.put(user.getUserId(), userAmount);

        }

        return amounts;
    }

    private void validateUserAmountMap(BigDecimal amount) {
        BigDecimal amountSum = userAmountMap.values().stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        if (amount.compareTo(amountSum) != 0)
            throw new IllegalArgumentException(
                    "Sum of amounts used to split expense is not equal to the total amount.");

    }

}
