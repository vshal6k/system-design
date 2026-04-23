package algomaster.problems.parkinglot.domainmodel;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import algomaster.problems.parkinglot.enums.SpotSize;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class Floor {
    private final int floorNumber;
    private final ConcurrentHashMap<String, Spot> spots;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        spots = new ConcurrentHashMap<>();
    }

    public void addSpot(Spot spot) {
        spots.put(spot.getSpotId(), spot);
    }

    public synchronized Optional<Spot> findAvailableSpot(Vehicle vehicle) {
        return spots.values().stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(Spot::getSpotSize))
                .findFirst();
    }

    public void displayAvailability() {
        System.out.printf("--- Floor %d Availability ---\n", floorNumber);
        Map<SpotSize, Long> availableCounts = spots.values().stream()
                .filter(spot -> spot.isAvailable())
                .collect(Collectors.groupingBy(Spot::getSpotSize, Collectors.counting()));

        for (SpotSize size : SpotSize.values()) {
            System.out.printf("  %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }

}
