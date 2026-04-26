package algomaster.problems.moviebookingsystem.entities;

import java.util.List;
import java.util.UUID;

public class City {
    private final String id;
    private final String name;
    private final List<Cinema> cinemas;

    public City(String id, String name, List<Cinema> cinemas) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.cinemas = cinemas;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

}
