package algomaster.problems.moviebookingsystem.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.moviebookingsystem.entities.Booking;
import algomaster.problems.moviebookingsystem.entities.Show;
import algomaster.problems.moviebookingsystem.entities.User;

public class BookingRepository {
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();

    public void createBooking(User user, Show show) {
        Booking booking = new Booking(show, user);
        bookings.put(booking.getId(), booking);
    }
}
