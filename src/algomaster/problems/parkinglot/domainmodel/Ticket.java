package algomaster.problems.parkinglot.domainmodel;

import java.time.LocalDateTime;
import java.util.UUID;

import algomaster.problems.parkinglot.vehicle.Vehicle;

public class Ticket {
    private final String id;
    private final Vehicle vehicle;
    private final Spot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(Vehicle vehicle, Spot spot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setExitTime() {
        this.exitTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Spot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

}
