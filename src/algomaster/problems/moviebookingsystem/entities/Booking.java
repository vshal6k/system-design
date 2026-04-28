package algomaster.problems.moviebookingsystem.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Booking {
    private final String id;
    private final Show show;
    private final User user;
    private final List<Seat> seats;
    private final BigDecimal amount;
    private final Payment payment;

    private Booking(BookingBuilder builder) {
        this.id = UUID.randomUUID().toString();
        this.show = builder.show;
        this.user = builder.user;
        this.seats = builder.seats;
        this.amount = builder.amount;
        this.payment = builder.payment;
    }

    public static class BookingBuilder {
        private Show show;
        private User user;
        private List<Seat> seats;
        private BigDecimal amount;
        private Payment payment;

        public BookingBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public BookingBuilder setShow(Show show) {
            this.show = show;
            return this;
        }

        public BookingBuilder setSeats(List<Seat> seats) {
            this.seats = seats;
            return this;
        }

        public BookingBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public BookingBuilder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Booking build() {
            // Validations can be added here
            return new Booking(this);
        }

    }

}
