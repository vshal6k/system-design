package algomaster.problems.moviebookingsystem.strategy.paymentmethod;

import java.math.BigDecimal;

import algomaster.problems.moviebookingsystem.entities.Payment;

public interface PaymentStrategy {

    Payment pay(BigDecimal amount);

}
