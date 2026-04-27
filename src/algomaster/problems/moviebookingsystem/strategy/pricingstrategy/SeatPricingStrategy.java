package algomaster.problems.moviebookingsystem.strategy.pricingstrategy;

import java.math.BigDecimal;

import algomaster.problems.moviebookingsystem.entities.Seat;

public interface SeatPricingStrategy {

    BigDecimal calculatePrice(Seat seat);

}
