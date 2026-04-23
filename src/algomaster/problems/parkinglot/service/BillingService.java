package algomaster.problems.parkinglot.service;

import java.math.BigDecimal;

import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.strategy.fee.FeeStrategy;

//Responsible for creating bill from tickets
public class BillingService {
    private final FeeStrategy pricingStrategy;

    public BillingService(FeeStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public BigDecimal calculateCharge(Ticket ticket) {
        return pricingStrategy.calculate(ticket);
    }

}
