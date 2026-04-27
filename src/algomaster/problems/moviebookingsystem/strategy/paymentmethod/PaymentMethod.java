package algomaster.problems.moviebookingsystem.strategy.paymentmethod;

import java.math.BigDecimal;

public interface PaymentMethod {

    // Payment Strategy contract: Return true if payment is successful, else return
    // false;
    boolean pay(BigDecimal price);

}
