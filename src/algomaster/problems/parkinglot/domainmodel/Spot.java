package algomaster.problems.parkinglot.domainmodel;

import java.util.UUID;

import algomaster.problems.parkinglot.enums.SpotSize;
import algomaster.problems.parkinglot.enums.VehicleSize;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class Spot {
    private final String spotId;
    private boolean isOccupied;
    private final SpotSize spotSize;
    private Vehicle parkedVehicle;

    public Spot(SpotSize spotSize) {
        this.spotId = UUID.randomUUID().toString();
        this.spotSize = spotSize;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        VehicleSize vehicleSize = vehicle.getSize();
        boolean canFitVehicle = false;

        switch (vehicleSize) {
            case SMALL:
                if (SpotSize.SMALL.equals(spotSize))
                    canFitVehicle = true;
                break;
            case MEDIUM:
                if (SpotSize.MEDIUM.equals(spotSize) || SpotSize.LARGE.equals(spotSize))
                    canFitVehicle = true;
                break;
            case LARGE:
                if (SpotSize.LARGE.equals(spotSize))
                    canFitVehicle = true;
                break;
        }

        return canFitVehicle;
    }

    public synchronized void unPark() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public synchronized void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

}
