package algomaster.problems.moviebookingsystem.strategy.pricingstrategy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.moviebookingsystem.entities.Seat;
import algomaster.problems.moviebookingsystem.enums.SeatType;

public class RegularPricingStrategy implements SeatPricingStrategy {

    private final Map<SeatType, BigDecimal> prices = new ConcurrentHashMap<>();

    public RegularPricingStrategy() {
        prices.put(SeatType.REGULAR, BigDecimal.valueOf(250));
        prices.put(SeatType.PREMIUM, BigDecimal.valueOf(500));
    }

    @Override
    public BigDecimal calculatePrice(Seat seat) {
        return prices.get(seat.getType());
    }

}
