package algomaster.problems.parkinglot.pricingstrategy;

import java.math.BigDecimal;

import algomaster.problems.parkinglot.domainmodel.Ticket;

public interface PricingStrategy {

    BigDecimal calculate(Ticket ticket);

}
