package algomaster.problems.splitwise.splitstrategy;

import java.math.BigDecimal;
import java.util.List;

import algomaster.problems.splitwise.entities.Split;
import algomaster.problems.splitwise.entities.User;

public interface SplitStrategy {
    public List<Split> split(BigDecimal amount, List<User> users);
}
