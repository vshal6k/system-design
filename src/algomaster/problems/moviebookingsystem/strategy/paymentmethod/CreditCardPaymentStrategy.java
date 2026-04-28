package algomaster.problems.moviebookingsystem.strategy.paymentmethod;

import java.math.BigDecimal;
import java.util.UUID;

import algomaster.problems.moviebookingsystem.entities.Payment;
import algomaster.problems.moviebookingsystem.enums.PaymentStatus;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    private final String cardNumber;
    private final String cvv;

    public CreditCardPaymentStrategy(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public Payment pay(BigDecimal amount) {
        System.out.printf("Processing credit card payment of $%.2f%n", amount);

        // Simulate payment gateway interaction
        boolean paymentSuccess = Math.random() > 0.05; // 95% success rate

        return new Payment(
                amount,
                paymentSuccess ? PaymentStatus.SUCCESS : PaymentStatus.FAILURE,
                "TXN_" + UUID.randomUUID());
    }
}
