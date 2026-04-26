package algomaster.problems.moviebookingsystem.entities;

import java.util.UUID;

public class Movie {
    private final String id;
    private final String title;

    public Movie(String id, String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
