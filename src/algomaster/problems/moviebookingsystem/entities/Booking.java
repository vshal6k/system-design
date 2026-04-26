package algomaster.problems.moviebookingsystem.entities;

public class Booking {
    private final Show show;
    private final User user;

    public Booking(Show show, User user) {
        this.show = show;
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

}
