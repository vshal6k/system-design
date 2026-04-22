package algomaster.problems.parkinglot.domainmodel;

import java.util.UUID;

import algomaster.problems.parkinglot.enums.VehicleType;

public class Vehicle {
    private final String id;
    private final VehicleType vehicleType;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle(VehicleType vehicleType) {
        this.id = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

}
