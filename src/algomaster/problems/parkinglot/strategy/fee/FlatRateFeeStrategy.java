package algomaster.problems.parkinglot.strategy.fee;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import algomaster.problems.parkinglot.domainmodel.Ticket;

public class FlatRateFeeStrategy implements FeeStrategy {
    public static final int RATE_PER_SECOND = 10;

    @Override
    public BigDecimal calculate(Ticket ticket) {
        LocalDateTime startTime = ticket.getEntryTime();
        LocalDateTime endTime = ticket.getExitTime();

        long seconds = Duration.between(startTime, endTime).toSeconds();

        return BigDecimal.valueOf(seconds * RATE_PER_SECOND);
    }

}
