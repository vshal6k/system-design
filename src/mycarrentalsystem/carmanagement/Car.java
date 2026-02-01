package mycarrentalsystem.carmanagement;

import mycarrentalsystem.carmanagement.cartype.CarType;
import mycarrentalsystem.locationmanagement.Location;

public class Car {
    private int id;
    public int getId() {
        return id;
    }

    private String modelName;
    private CarType carType;
    private double rentalPricePerHour;
    private boolean available;
    public Location location;

    public double getRentalPricePerHour(){
        return rentalPricePerHour;
    }
}
