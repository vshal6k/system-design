package algomaster.problems.moviebookingsystem.enums;

import java.math.BigDecimal;

public enum SeatType {
    REGULAR(BigDecimal.valueOf(50.0)),
    PREMIUM(BigDecimal.valueOf(80.0)),
    RECLINER(BigDecimal.valueOf(120.0));

    private final BigDecimal price;

    SeatType(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
