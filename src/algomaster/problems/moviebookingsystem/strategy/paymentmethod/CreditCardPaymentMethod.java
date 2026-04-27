package algomaster.problems.moviebookingsystem.strategy.paymentmethod;

import java.math.BigDecimal;

public class CreditCardPaymentMethod implements PaymentMethod {

    @Override
    public boolean pay(BigDecimal price) {
        System.out.println(price + " paid with credit card.");
        return true;
    }

}
