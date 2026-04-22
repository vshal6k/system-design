package algomaster.problems.parkinglot.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.parkinglot.domainmodel.Lot;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.domainmodel.Vehicle;
import algomaster.problems.parkinglot.enums.SpotSize;

//Responsible for managing spots, availability, assignment
public class SpotManagementService {
    private final Lot lot; // Lot reference managed by this service
    private ConcurrentHashMap<String, Spot> vehicleSpotMap = new ConcurrentHashMap<>();

    public SpotManagementService(Lot lot) {
        this.lot = lot;
    }

    public Spot getSpotForVehicle(String vehicleId) {
        Spot spot = vehicleSpotMap.get(vehicleId);
        if (spot == null)
            throw new IllegalArgumentException("Vehicle is not parked.");
        return spot;
    }

    public boolean isParked(Vehicle vehicle) {
        return (vehicleSpotMap.get(vehicle.getId()) != null);
    }

    public Spot park(Vehicle vehicle) {
        if (isParked(vehicle))
            throw new IllegalArgumentException("Vehicle is already parked.");

        Optional<Spot> spotOptional = lot.findAvailableSpot(vehicle);
        if (spotOptional.isEmpty())
            throw new IllegalStateException("No available parking spot found for the vehicle");

        Spot spot = spotOptional.get();
        vehicleSpotMap.put(vehicle.getId(), spot);
        spot.park(vehicle);
        return spot;
    }

    public void unPark(Vehicle vehicle) {
        Spot spot = getSpotForVehicle(vehicle.getId());
        spot.unPark();
    }

    public List<Spot> filterAvailableSpotByFloor(int floorNumber) {
        return lot.filterAvailableSpotByFloor(floorNumber);
    }

    public List<Spot> filterAvailableSpotBySize(SpotSize spotSize) {
        return lot.filterAvailableSpotBySize(spotSize);
    }

    public void displayAvailableSpotBySize(SpotSize spotSize) {
        lot.displayAvailableSpotBySize(spotSize);
    }

    public void displayAvailableSpotByFloor(int floorNumber) {
        lot.displayAvailableSpotByFloor(floorNumber);
    }

}
