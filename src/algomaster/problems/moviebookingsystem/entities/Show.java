package algomaster.problems.moviebookingsystem.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.moviebookingsystem.enums.SeatStatus;
import algomaster.problems.moviebookingsystem.strategy.pricingstrategy.SeatPricingStrategy;

public class Show {
    private final String id;
    private final City city;
    private final Cinema cinema;
    private final Screen screen;
    private final Movie movie;
    private final Map<String, ShowSeat> showSheats;
    private final LocalDateTime time;

    public Show(City city, Cinema cinema, Screen screen, Movie movie, LocalDateTime time,
            SeatPricingStrategy pricingStrategy) {
        this.id = UUID.randomUUID().toString();
        this.city = city;
        this.cinema = cinema;
        this.screen = screen;
        this.movie = movie;
        this.time = time;
        this.showSheats = new ConcurrentHashMap<>();
        initialiseShowSeats(screen, pricingStrategy);
    }

    public Movie getMovie() {
        return movie;
    }

    private void initialiseShowSeats(Screen screen, SeatPricingStrategy pricingStrategy) {
        screen.getSeats().stream().forEach(
                seat -> showSheats.put(seat.getId(), new ShowSeat(seat, pricingStrategy.calculatePrice(seat))));
    }

    public String getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean isSeatAvailable(Seat seat) {
        ShowSeat showSeat = getShowSeat(seat);
        return SeatStatus.AVAILABLE.equals(showSeat.getStatus()) ? true : false;
    }

    public ShowSeat getShowSeat(Seat seat) {
        ShowSeat showSeat = showSheats.get(seat.getId());
        if (showSeat == null)
            throw new IllegalArgumentException("Seat does not belong to this show");
        return showSeat;
    }

    public List<ShowSeat> getAllShowSeats() {
        return new ArrayList<>(showSheats.values());
    }

}
