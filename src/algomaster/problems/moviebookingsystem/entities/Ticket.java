package algomaster.problems.moviebookingsystem.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class Ticket {
    private final String id;
    private final Show show;
    private final Seat seat;
    private final User user;
    private final BigDecimal price;

    public Ticket(String id, Show show, Seat seat, User user, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.show = show;
        this.seat = seat;
        this.user = user;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public Seat getSeat() {
        return seat;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
