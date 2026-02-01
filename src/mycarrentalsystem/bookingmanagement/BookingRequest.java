package mycarrentalsystem.bookingmanagement;

import java.time.LocalDateTime;

import mycarrentalsystem.carmanagement.Car;
import mycarrentalsystem.usermanagement.User;

public class BookingRequest {
    private User user;
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

    private Car car;
    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;

    public BookingRequest(User user, Car car, LocalDateTime bookingStart, LocalDateTime bookingEnd) {
        this.user = user;
        this.car = car;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
    }
}
