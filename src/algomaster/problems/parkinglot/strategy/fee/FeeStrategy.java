package algomaster.problems.parkinglot.strategy.fee;

import java.math.BigDecimal;

import algomaster.problems.parkinglot.domainmodel.Ticket;

public interface FeeStrategy {

    BigDecimal calculate(Ticket ticket);

}
