package algomaster.problems.splitwise.splitstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import algomaster.problems.splitwise.entities.Split;
import algomaster.problems.splitwise.entities.User;

public class ExactAmountSplitStrategy implements SplitStrategy {
    private final List<BigDecimal> splitValues;

    public ExactAmountSplitStrategy(List<BigDecimal> splitValues) {
        if (splitValues == null || splitValues.isEmpty())
            throw new IllegalArgumentException("Split value cannot be null for percentage split strategy.");
        this.splitValues = splitValues;
    }

    @Override
    public List<Split> split(BigDecimal amount, List<User> users) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0)
            throw new IllegalArgumentException("Amount cannot be null or zero.");

        if (users == null || users.isEmpty())
            throw new IllegalArgumentException("Users cannot be null/empty.");

        if (splitValues.size() != users.size())
            throw new IllegalArgumentException(
                    "Number of split values do not match the number of participants in the expense.");

        BigDecimal splitVaulesSum = splitValues.stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        if (splitVaulesSum.compareTo(amount) != 0)
            throw new IllegalArgumentException("Split values do not sum up to the total amount");

        List<Split> splits = new ArrayList<>();

        BigDecimal userAmountSum = BigDecimal.ZERO;

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            BigDecimal userAmount = splitValues.get(i).setScale(2, RoundingMode.HALF_UP);
            if (userAmount == null)
                throw new IllegalArgumentException("No amount data found for the user " + user.getName());

            splits.add(new Split(user, userAmount));
            userAmountSum = userAmountSum.add(userAmount);
        }

        BigDecimal leftOverAmount = amount.subtract(userAmountSum);
        Split lastSplit = splits.getLast();
        Split lastSplitPlusLeftOver = new Split(lastSplit.getUser(), lastSplit.getAmount().add(leftOverAmount));
        splits.set(splits.size() - 1, lastSplitPlusLeftOver);

        return splits;
    }

}
