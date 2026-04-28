package algomaster.problems.moviebookingsystem.strategy.pricingstrategy;

import java.math.BigDecimal;
import java.util.List;

import algomaster.problems.moviebookingsystem.entities.Seat;

public class WeekendPricingStrategy implements PricingStrategy {
    private static final BigDecimal WEEKEND_SURCHARGE = BigDecimal.valueOf(1.2); // 20% surcharge

    @Override
    public BigDecimal calculatePrice(List<Seat> seats) {
        BigDecimal basePrice = seats.stream().map(seat -> seat.getType().getPrice()).reduce(BigDecimal.ZERO,
                (a, b) -> a.add(b));

        return basePrice.multiply(WEEKEND_SURCHARGE);
    }

}
