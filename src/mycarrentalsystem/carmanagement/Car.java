package mycarrentalsystem.carmanagement;

import mycarrentalsystem.carmanagement.cartype.CarType;
import mycarrentalsystem.locationmanagement.Location;

public class Car {
    private int id;
    private String modelName;
    private CarType carType;
    private int rentalPricePerHour;
    private boolean available;
    public Location location;
}
