package algomaster.problems.parkinglot.vehicle;

import algomaster.problems.parkinglot.enums.VehicleSize;

public class Vehicle {
    private final String id;
    private final VehicleSize size;

    public Vehicle(String id, VehicleSize size) {
        this.id = id;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public VehicleSize getSize() {
        return size;
    }
}
