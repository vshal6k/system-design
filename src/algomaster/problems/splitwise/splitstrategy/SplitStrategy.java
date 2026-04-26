package algomaster.problems.splitwise.splitstrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import algomaster.problems.splitwise.entities.User;

public interface SplitStrategy {
    public Map<String, BigDecimal> split(BigDecimal amount, List<User> users);
}
