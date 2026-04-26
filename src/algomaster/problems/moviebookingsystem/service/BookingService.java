package algomaster.problems.moviebookingsystem.service;

import java.math.BigDecimal;

import algomaster.problems.moviebookingsystem.entities.Seat;
import algomaster.problems.moviebookingsystem.entities.Show;
import algomaster.problems.moviebookingsystem.entities.ShowSeat;
import algomaster.problems.moviebookingsystem.entities.User;
import algomaster.problems.moviebookingsystem.enums.SeatStatus;

//Use Case: Book a show for a user and create a booking.
public class BookingService {
    private final PaymentService paymentService = new PaymentService();

    // Check availability of the showseat
    // Lock the seat so tht other users cannot book it
    // Calculate price for the showseat
    // Process the payment for the seat
    // If payment succeeds, book the seat. Else, release the lock.
    public void book(User user, Show show, Seat seat) {
        // Check availability of the showseat
        boolean isAvailable = show.isSeatAvailable(seat);
        if (!isAvailable)
            throw new IllegalStateException("Seat is not available for booking.");

        // Lock the seat so tht other users cannot book it
        ShowSeat showSeat = show.getShowSeat(seat);
        showSeat.setStatus(SeatStatus.LOCKED);

        // Try to process the payment for the seat and update the seat status
        try {
            boolean isSuccessful = paymentService.processPayment(showSeat.getPrice());
            showSeat.setStatus(isSuccessful ? SeatStatus.BOOKED : SeatStatus.AVAILABLE);
        } catch (Exception e) {
            showSeat.setStatus(SeatStatus.AVAILABLE);
        }

    }

}
