package algomaster.problems.splitwise.splitstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import algomaster.problems.splitwise.entities.Split;
import algomaster.problems.splitwise.entities.User;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> split(BigDecimal amount, List<User> users) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0)
            throw new IllegalArgumentException("Amount cannot be null or zero.");

        if (users == null || users.isEmpty())
            throw new IllegalArgumentException("Users cannot be null/empty.");

        List<Split> splits = new ArrayList<>();

        int totalUsers = users.size();
        BigDecimal dividedAmount = amount.divide(BigDecimal.valueOf(totalUsers), 2, RoundingMode.HALF_UP);
        BigDecimal leftOverAmount = amount.subtract(dividedAmount.multiply(BigDecimal.valueOf(totalUsers)));

        for (int i = 0; i < totalUsers; i++) {
            User user = users.get(i);
            splits.add(new Split(user, dividedAmount));
        }

        Split lastSplit = splits.getLast();
        Split lastSplitPlusLeftOver = new Split(lastSplit.getUser(), lastSplit.getAmount().add(leftOverAmount));
        splits.set(splits.size() - 1, lastSplitPlusLeftOver);

        return splits;

    }

}
