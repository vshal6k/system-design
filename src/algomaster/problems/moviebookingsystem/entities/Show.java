package algomaster.problems.moviebookingsystem.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import algomaster.problems.moviebookingsystem.strategy.pricingstrategy.PricingStrategy;

public class Show {
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final LocalDateTime startTime;
    private final PricingStrategy pricingStrategy;

    public Show(Movie movie, Screen screen, LocalDateTime startTime, PricingStrategy pricingStrategy) {
        this.id = UUID.randomUUID().toString();
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.pricingStrategy = pricingStrategy;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

}
