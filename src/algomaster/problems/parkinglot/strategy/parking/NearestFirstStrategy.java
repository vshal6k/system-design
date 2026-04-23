package algomaster.problems.parkinglot.strategy.parking;

import java.util.List;
import java.util.Optional;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class NearestFirstStrategy implements ParkingStrategy {

    @Override
    public Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle) {
        for (Floor floor : floors) {
            Optional<Spot> spotOptional = floor.findAvailableSpot(vehicle);
            if (spotOptional.isPresent())
                return spotOptional;
        }
        return Optional.empty();
    }
}
