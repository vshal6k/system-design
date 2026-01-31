package mycarrentalsystem.bookingmanagement;

import java.util.ArrayList;

public class BookingRepository {
    public static ArrayList<Booking> bookings;

    public static void addBooking(Booking booking){
        bookings.add(booking);
    }

    public static void removeBooking(Booking booking) {
        bookings.remove(booking);
    }
    
}
