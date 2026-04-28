package algomaster.problems.moviebookingsystem.service;

import java.math.BigDecimal;

import algomaster.problems.moviebookingsystem.strategy.paymentmethod.PaymentStrategy;

public class PaymentService {
    private final PaymentStrategy paymentMethod;

    public PaymentService(PaymentStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean processPayment(BigDecimal price) {
        return paymentMethod.pay(price);
    }

}
