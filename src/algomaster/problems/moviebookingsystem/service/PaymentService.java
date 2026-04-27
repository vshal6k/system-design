package algomaster.problems.moviebookingsystem.service;

import java.math.BigDecimal;

import algomaster.problems.moviebookingsystem.strategy.paymentmethod.PaymentMethod;

public class PaymentService {
    private final PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean processPayment(BigDecimal price) {
        return paymentMethod.pay(price);
    }

}
