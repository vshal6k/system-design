package algomaster.problems.parkinglot.strategy.fee;

import java.math.BigDecimal;

import algomaster.problems.parkinglot.domainmodel.Ticket;

public class FlatRateFeeStrategy implements FeeStrategy {
    public static final int RATE_PER_SECOND = 10;

    @Override
    public BigDecimal calculate(Ticket ticket) {
        return BigDecimal.TEN;
    }

}
