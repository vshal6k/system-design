package algomaster.problems.moviebookingsystem.entities;

import java.util.List;
import java.util.UUID;

public class Cinema {
    private final String id;
    private final String name;
    private final List<Screen> screens;

    public Cinema(String name, List<Screen> screens) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.screens = screens;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return List.copyOf(screens);
    }

}
