package algomaster.problems.parkinglot.domainmodel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import algomaster.problems.parkinglot.enums.SpotSize;

public class Lot {
    private final List<Floor> floors;

    public Lot(List<Floor> floors) {
        if (floors.isEmpty())
            throw new IllegalArgumentException("Parking lot should have at least one floor.");
        this.floors = List.copyOf(floors);
    }

    public Optional<Spot> findAvailableSpot(Vehicle vehicle) {
        return floors.stream()
                .flatMap(floor -> floor.getSpots().stream())
                .filter(spot -> spot.canPark(vehicle))
                .findAny();
    }

    public List<Spot> filterAvailableSpotByFloor(int floorNumber) {
        if (floorNumber >= floors.size())
            throw new IllegalArgumentException("Please provide a valid floor number");

        return floors.get(floorNumber)
                .getSpots()
                .stream()
                .filter(spot -> spot.isAvailable())
                .collect(Collectors.toList());
    }

    public List<Spot> filterAvailableSpotBySize(SpotSize spotSize) {
        if (spotSize == null)
            throw new IllegalArgumentException("Please provide a valid value of spot size.");

        return floors.stream()
                .flatMap(floor -> floor.getSpots().stream())
                .filter(spot -> spot.getSpotSize().equals(spotSize) && spot.isAvailable())
                .collect(Collectors.toList());

    }

    public void displayAvailableSpotBySize(SpotSize spotSize) {
        if (spotSize == null)
            throw new IllegalArgumentException("Please provide a valid value of spot size.");

        System.out.println("Spots with size " + spotSize.toString());

        for (int i = 0; i < floors.size(); i++) {
            List<Spot> spots = floors.get(i).getSpots();
            System.out.println("Spots Available In Floor " + i);
            for (Spot spot : spots) {
                if (!(spot.getSpotSize().equals(spotSize) && spot.isAvailable()))
                    continue;
                System.out.println("  " + spot.getId() + " " + spot.getSpotSize());
            }
        }
    }

    public void displayAvailableSpotByFloor(int floorNumber) {
        if (floorNumber >= floors.size())
            throw new IllegalArgumentException("Please provide a valid floor number");

        List<Spot> spots = floors.get(floorNumber).getSpots();
        System.out.println("Spots Available In Floor " + floorNumber);
        for (Spot spot : spots) {
            if (!spot.isAvailable())
                continue;
            System.out.println("  " + spot.getId() + " " + spot.getSpotSize());
        }

    }
}
