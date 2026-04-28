package algomaster.problems.moviebookingsystem.strategy.pricingstrategy;

import java.math.BigDecimal;
import java.util.List;

import algomaster.problems.moviebookingsystem.entities.Seat;

public class WeekdayPricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal calculatePrice(List<Seat> seats) {
        return seats.stream().map(seat -> seat.getType().getPrice()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

}
