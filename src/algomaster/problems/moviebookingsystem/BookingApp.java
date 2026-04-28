package algomaster.problems.moviebookingsystem;

import java.time.LocalDateTime;

import algomaster.problems.moviebookingsystem.entities.Cinema;
import algomaster.problems.moviebookingsystem.entities.City;
import algomaster.problems.moviebookingsystem.entities.Movie;
import algomaster.problems.moviebookingsystem.entities.Screen;
import algomaster.problems.moviebookingsystem.entities.Show;
import algomaster.problems.moviebookingsystem.entities.User;
import algomaster.problems.moviebookingsystem.service.BookingService;
import algomaster.problems.moviebookingsystem.service.PaymentService;
import algomaster.problems.moviebookingsystem.service.SearchService;
import algomaster.problems.moviebookingsystem.storage.BookingRepository;
import algomaster.problems.moviebookingsystem.storage.ShowRepository;
import algomaster.problems.moviebookingsystem.storage.UserRepository;
import algomaster.problems.moviebookingsystem.strategy.pricingstrategy.PricingStrategy;

//Facade to provide simple interface to users
public class BookingApp {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;
    private final BookingService bookingService;
    private final PaymentService paymentService;
    private final SearchService searchService;

    public User createUser(String name) {
        return userRepository.createUser(name);
    }

    public BookingApp() {
        this.userRepository = new UserRepository();
        this.showRepository = new ShowRepository();
        this.bookingRepository = new BookingRepository();
    }

    public Show createShow(City city, Cinema cinema, Screen screen, Movie movie, LocalDateTime time, PricingStrategy pricingStrategy) {
        return showRepository.createShow(city, cinema, screen, movie, time, pricingStrategy);
    }

}
