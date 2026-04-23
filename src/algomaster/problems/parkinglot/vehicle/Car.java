package algomaster.problems.parkinglot.vehicle;

import algomaster.problems.parkinglot.enums.VehicleSize;

public class Car extends Vehicle {

    public Car(String licenseNumber) {
        super(licenseNumber, VehicleSize.MEDIUM);
    }

}
