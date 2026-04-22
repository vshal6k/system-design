package algomaster.problems.parkinglot.domainmodel;

import java.util.List;

public class Floor {
    private final List<Spot> spots;

    public Floor(List<Spot> spots) {
        if (spots.isEmpty())
            throw new IllegalArgumentException("Floor should have at least one spot.");
        this.spots = List.copyOf(spots);
    }

    public List<Spot> getSpots() {
        return List.copyOf(spots);
    }

}
