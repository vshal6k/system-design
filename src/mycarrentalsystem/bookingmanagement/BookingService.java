package mycarrentalsystem.bookingmanagement;

public class BookingService {
    

    public void createBooking(Booking booking) {
        BookingRepository.addBooking(booking);
    }
}
