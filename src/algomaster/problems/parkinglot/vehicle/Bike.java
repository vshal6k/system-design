package algomaster.problems.parkinglot.vehicle;

import algomaster.problems.parkinglot.enums.VehicleSize;

public class Bike extends Vehicle {

    public Bike(String licenseNumber) {
        super(licenseNumber, VehicleSize.SMALL);
    }

}
