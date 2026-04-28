package algomaster.problems.moviebookingsystem.entities;

import java.math.BigDecimal;
import java.util.UUID;

import algomaster.problems.moviebookingsystem.enums.PaymentStatus;

public class Payment {
    private final String id;
    private final BigDecimal amount;
    private final PaymentStatus status;
    private final String transactionId;

    public Payment(BigDecimal amount, PaymentStatus status, String transactionId) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.status = status;
        this.transactionId = transactionId;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
