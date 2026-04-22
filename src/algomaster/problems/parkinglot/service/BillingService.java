package algomaster.problems.parkinglot.service;

import java.math.BigDecimal;

import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.pricingstrategy.PricingStrategy;

//Responsible for creating bill from tickets
public class BillingService {
    private final PricingStrategy pricingStrategy;

    public BillingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public BigDecimal calculateCharge(Ticket ticket) {
        return pricingStrategy.calculate(ticket);
    }

}
