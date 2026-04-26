package algomaster.problems.moviebookingsystem.entities;

import java.math.BigDecimal;

import algomaster.problems.moviebookingsystem.enums.SeatStatus;

public class ShowSeat {
    private final Seat seat;
    private SeatStatus status;
    private final BigDecimal price;

    public ShowSeat(Seat seat, BigDecimal price) {
        this.seat = seat;
        this.status = SeatStatus.AVAILABLE;
        this.price = price;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
		return price;
	}

	public Seat getSeat() {
        return seat;
    }

    public SeatStatus getStatus() {
        return status;
    }

}
