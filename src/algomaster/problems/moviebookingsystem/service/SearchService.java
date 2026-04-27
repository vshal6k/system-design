package algomaster.problems.moviebookingsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import algomaster.problems.moviebookingsystem.entities.City;
import algomaster.problems.moviebookingsystem.entities.Seat;
import algomaster.problems.moviebookingsystem.entities.Show;
import algomaster.problems.moviebookingsystem.storage.ShowRepository;

//Service that allows user to search for shows based on movie title and city
public class SearchService {
    private final ShowRepository showRepository;

    // Search service can be used to search any show repository
    public SearchService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    // Enables user to search for shows using movie and title
    public List<Show> getShowByMovieAndTitle(String movieTitle, City city) {
        return showRepository.getAllShows()
                .stream()
                .filter(show -> {
                    if (movieTitle != null && !show.getMovie().getTitle().equals(movieTitle)) {
                        return false;
                    }
                    if (city != null && !city.getId().equals(show.getCity().getId())) {
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }

    // Enables user to query available seats for a show
    public List<Seat> getAvailableSeatsForShow(Show show) {
        return show.getAllShowSeats()
                .stream()
                .filter(showSeat -> showSeat.isAvailable())
                .map(showSeat -> showSeat.getSeat())
                .collect(Collectors.toList());
    }

}
