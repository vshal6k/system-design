package mycarrentalsystem.bookingmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

import mycarrentalsystem.bookingmanagement.bookingstatus.BookingStatus;
import mycarrentalsystem.carmanagement.Car;

public class InMemoryBookingRepository implements BookingRepository {
    private ArrayList<Booking> bookings = new ArrayList<>();

    @Override
    public void saveBooking(Booking booking) {
        bookings.add(booking);
    }

    public boolean hasOverlappingBooking(Car car, LocalDateTime bookingStart, LocalDateTime bookingEnd) {
        for (Booking booking : bookings) {
            if (booking.getCar().getId() == car.getId() && bookingStart.isBefore(booking.getBookingEnd())
                    && booking.getBookingStart().isBefore(bookingEnd)
                    && (booking.getBookingStatus() == BookingStatus.ACTIVE
                            || booking.getBookingStatus() == BookingStatus.RESERVED))
                return true;
        }
        return false;
    }

    public void updateBookingStatus(int bookingId, BookingStatus bookingStatus) {
        for (Booking booking2 : bookings) {
            if (booking2.getId() == bookingId) {
                booking2.setBookingStatus(bookingStatus);
                break;
            }
        }
    }

}
