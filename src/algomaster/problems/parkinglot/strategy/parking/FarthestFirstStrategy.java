package algomaster.problems.parkinglot.strategy.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class FarthestFirstStrategy implements ParkingStrategy {

    @Override
    public Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle) {
        List<Floor> reversedFloors = new ArrayList<>(floors);
        Collections.reverse(reversedFloors);

        for (Floor floor : reversedFloors) {
            Optional<Spot> spotOptional = floor.findAvailableSpot(vehicle);
            if (spotOptional.isPresent())
                return spotOptional;
        }
        return Optional.empty();
    }

}
