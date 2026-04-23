package algomaster.problems.parkinglot.strategy.parking;

import java.util.List;
import java.util.Optional;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class BestFitStrategy implements ParkingStrategy {

    @Override
    public Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle) {
        Optional<Spot> bestSpot = Optional.empty();
        for (Floor floor : floors) {
            Optional<Spot> spotOnThisFloor = floor.findAvailableSpot(vehicle);

            if (spotOnThisFloor.isPresent()) {
                if (bestSpot.isEmpty())
                    bestSpot = spotOnThisFloor;
                else if (spotOnThisFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal())
                    bestSpot = spotOnThisFloor;
            }
        }
        return bestSpot;
    }

}
