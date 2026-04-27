package algomaster.problems.moviebookingsystem.storage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.moviebookingsystem.entities.Cinema;
import algomaster.problems.moviebookingsystem.entities.City;
import algomaster.problems.moviebookingsystem.entities.Movie;
import algomaster.problems.moviebookingsystem.entities.Screen;
import algomaster.problems.moviebookingsystem.entities.Show;
import algomaster.problems.moviebookingsystem.strategy.pricingstrategy.SeatPricingStrategy;

public class ShowRepository {
    private final Map<String, Show> shows = new ConcurrentHashMap<>();

    public Show createShow(City city, Cinema cinema, Screen screen, Movie movie, LocalDateTime time,
            SeatPricingStrategy pricingStrategy) {
        Show show = new Show(city, cinema, screen, movie, time, pricingStrategy);
        shows.put(show.getId(), show);
        return show;
    }

    public Show getShow(String userId) {
        Show show = shows.get(userId);
        if (show == null)
            throw new IllegalArgumentException("Show not found.");
        return show;
    }

    public List<Show> getAllShows() {
        return new ArrayList<>(shows.values());
    }

}
