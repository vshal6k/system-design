package algomaster.problems.moviebookingsystem.entities;

import java.util.UUID;

import algomaster.problems.moviebookingsystem.observer.MovieSubject;

public class Movie extends MovieSubject{
    private final String id;
    private final String title;
    private final int durationInMinutes;

    public Movie(String title, int durationInMinutes) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    // Additional movie details like genre, language etc. can be added here

}
