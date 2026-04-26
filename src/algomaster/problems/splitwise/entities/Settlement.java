package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;

public class Settlement extends PaymentActivity {
    private final User receiver;

    public Settlement(User payer, User receiver, BigDecimal amount) {
        super(payer, amount);
        this.receiver = receiver;
    }

    public User getReceiver() {
        return receiver;
    }

}
