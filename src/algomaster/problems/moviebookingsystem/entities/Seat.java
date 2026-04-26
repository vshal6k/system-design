package algomaster.problems.moviebookingsystem.entities;

import java.util.UUID;

import algomaster.problems.moviebookingsystem.enums.SeatType;

public class Seat {
    private final String id;
    private final String name;
    private final SeatType type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Seat(String name, SeatType type, boolean isAvailable) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
    }

    public SeatType getType() {
        return type;
    }

}
