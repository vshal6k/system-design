package mycarrentalsystem.bookingmanagement;

import java.time.LocalDateTime;

import mycarrentalsystem.bookingmanagement.bookingstatus.BookingStatus;
import mycarrentalsystem.carmanagement.Car;
import mycarrentalsystem.usermanagement.User;

public class Booking {
    private static int maxId = 0;
    private int id;
    private User user;
    private Car car;
    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;
    private double price;
    private BookingStatus bookingStatus;

    public Booking(User user, Car car, LocalDateTime bookingStart, LocalDateTime bookingEnd, double price,
            BookingStatus bookingStatus) {
        this.id = ++Booking.maxId;
        this.car = car;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public static int getMaxId() {
        return maxId;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getBookingStart() {
        return bookingStart;
    }

    public LocalDateTime getBookingEnd() {
        return bookingEnd;
    }

    public double getPrice() {
        return price;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    protected void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}
