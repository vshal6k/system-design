package algomaster.problems.moviebookingsystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String id;
    private final int number;
    private final List<Seat> seats;

    public Screen(String id, int number, List<Seat> seats) {
        this.id = id;
        this.number = number;
        this.seats = new ArrayList<>(seats);
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public List<Seat> getSeats() {
        return List.copyOf(seats);
    }

}
