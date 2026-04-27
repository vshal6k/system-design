package algomaster.problems.moviebookingsystem.service;

import algomaster.problems.moviebookingsystem.entities.Seat;
import algomaster.problems.moviebookingsystem.entities.Show;
import algomaster.problems.moviebookingsystem.entities.ShowSeat;
import algomaster.problems.moviebookingsystem.entities.User;
import algomaster.problems.moviebookingsystem.enums.SeatStatus;
import algomaster.problems.moviebookingsystem.storage.BookingRepository;
import algomaster.problems.moviebookingsystem.storage.ShowRepository;
import algomaster.problems.moviebookingsystem.storage.UserRepository;

//Use Case: Book a show for a user and create a booking.
public class BookingService {
    private final PaymentService paymentService;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;

    public BookingService(PaymentService paymentService, UserRepository userRepository, ShowRepository showRepository,
            BookingRepository bookingRepository) {
        this.paymentService = paymentService;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
    }

    // Check availability of the showseat
    // Lock the seat so tht other users cannot book it
    // Calculate price for the showseat
    // Process the payment for the seat
    // If payment succeeds, book the seat. Else, release the lock.
    public void book(String userId, String showId, Seat seat) {

        User user = userRepository.getUser(userId);
        Show show = showRepository.getShow(showId);

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

        // Create a booking record for history
        bookingRepository.createBooking(user, show);
    }

}
