package mycarrentalsystem.bookingmanagement;

import java.time.LocalDateTime;

import mycarrentalsystem.carmanagement.Car;
import mycarrentalsystem.usermanagement.User;

public class Booking {
    private int id;
    public User user;
    public Car car;
    public LocalDateTime bookingStart;
    public LocalDateTime bookingEnd;
    public int price;
}
