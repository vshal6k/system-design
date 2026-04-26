package algomaster.problems.splitwise.splitstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algomaster.problems.splitwise.entities.User;

public class EqualSplitStrategy implements SplitStrategy {

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

        BigDecimal dividedAmount = amount.divide(BigDecimal.valueOf(totalUsers), 2, RoundingMode.HALF_UP);
        BigDecimal leftOverAmount = amount.subtract(dividedAmount.multiply(BigDecimal.valueOf(totalUsers)));

        for (User user : users) {
            amounts.put(user.getUserId(), dividedAmount);
        }

        amounts.put(users.getLast().getUserId(), dividedAmount.add(leftOverAmount));
        return amounts;

    }

}
