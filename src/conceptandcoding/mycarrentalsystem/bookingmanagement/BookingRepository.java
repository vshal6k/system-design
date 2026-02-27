package mycarrentalsystem.bookingmanagement;

import java.time.LocalDateTime;

import mycarrentalsystem.bookingmanagement.bookingstatus.BookingStatus;
import mycarrentalsystem.carmanagement.Car;

public interface BookingRepository {
    public void saveBooking(Booking booking);

    public boolean hasOverlappingBooking(Car car, LocalDateTime bookingStart, LocalDateTime bookingEnd);

    public void updateBookingStatus(int bookingId, BookingStatus bookingStatus);
}
