package algomaster.problems.moviebookingsystem.strategy.pricingstrategy;

import java.math.BigDecimal;
import java.util.List;

import algomaster.problems.moviebookingsystem.entities.Seat;

public interface PricingStrategy {

    BigDecimal calculatePrice(List<Seat> seats);

}
