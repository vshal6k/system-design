package mycarrentalsystem.bookingmanagement;

import java.time.Duration;

import mycarrentalsystem.bookingmanagement.bookingstatus.BookingStatus;

public class BookingService {
    BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public boolean attemptBooking(BookingRequest bookingRequest) {
        if (!bookingRequest.getBookingStart().isBefore(bookingRequest.getBookingEnd())) return false;
        boolean hasOverlappingSlots = this.bookingRepository.hasOverlappingBooking(bookingRequest.getCar(),
                bookingRequest.getBookingStart(),
                bookingRequest.getBookingEnd());

        if (hasOverlappingSlots)
            return false;

        this.saveBooking(bookingRequest);
        return true;
    }

    public void saveBooking(BookingRequest bookingRequest) {
        double price = this.calculatePrice(bookingRequest);
        Booking booking = new Booking(bookingRequest.getUser(), bookingRequest.getCar(), bookingRequest.getBookingStart(),
                bookingRequest.getBookingEnd(), price, BookingStatus.RESERVED);
        this.bookingRepository.saveBooking(booking);

    }

    public double calculatePrice(BookingRequest bookingRequest) {
        double pricePerHour = bookingRequest.getCar().getRentalPricePerHour();
        Duration duration = Duration.between(bookingRequest.getBookingStart(), bookingRequest.getBookingEnd());
        double hours = duration.toMinutes() / 60.0;
        double price = hours * pricePerHour;
        return price;
    }

    public void setBookingStatus(int bookingId, BookingStatus bookingStatus) {
        this.bookingRepository.updateBookingStatus(bookingId, bookingStatus);
    }

}
