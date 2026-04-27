package algomaster.problems.moviebookingsystem.entities;

import java.util.UUID;

public class Booking {
    private final String id;
    private final Show show;
    private final User user;

    public Booking(Show show, User user) {
        this.id = UUID.randomUUID().toString();
        this.show = show;
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

}
