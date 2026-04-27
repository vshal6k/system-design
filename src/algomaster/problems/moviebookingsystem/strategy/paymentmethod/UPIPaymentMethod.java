package algomaster.problems.moviebookingsystem.strategy.paymentmethod;

import java.math.BigDecimal;

public class UPIPaymentMethod implements PaymentMethod {

    @Override
    public boolean pay(BigDecimal price) {
        System.out.println(price + " paid with UPI.");
        return true;
    }

}
