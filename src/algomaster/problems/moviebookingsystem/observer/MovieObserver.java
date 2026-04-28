package algomaster.problems.moviebookingsystem.observer;

import algomaster.problems.moviebookingsystem.entities.Movie;

public interface MovieObserver {
    void update(Movie movie);
}
