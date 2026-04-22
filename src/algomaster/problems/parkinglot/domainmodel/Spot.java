package algomaster.problems.parkinglot.domainmodel;

import java.util.UUID;

import algomaster.problems.parkinglot.enums.SpotSize;
import algomaster.problems.parkinglot.enums.VehicleType;

public class Spot {
    private final String id;
    private final SpotSize spotSize;
    private Vehicle vehicle;

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Spot(SpotSize spotSize, Vehicle vehicle) {
        this.id = UUID.randomUUID().toString();
        this.spotSize = spotSize;
        this.vehicle = vehicle;
    }

    public Spot(SpotSize spotSize) {
        this(spotSize, null);
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }

    public boolean isAvailable() {
        return (this.vehicle == null);
    }

    public boolean canPark(Vehicle vehicle) {
        if (this.vehicle != null)
            return false;

        VehicleType vehicleType = vehicle.getVehicleType();
        boolean canPark = false;

        switch (vehicleType) {
            case BIKE:
                if (SpotSize.SMALL.equals(spotSize))
                    canPark = true;
                break;
            case CAR:
                if (SpotSize.MEDIUM.equals(spotSize) || SpotSize.LARGE.equals(spotSize))
                    canPark = true;
                break;
            case TRUCK:
                if (SpotSize.LARGE.equals(spotSize))
                    canPark = true;
                break;
        }

        return canPark;
    }

    public void unPark() {
        this.vehicle = null;
    }

}
