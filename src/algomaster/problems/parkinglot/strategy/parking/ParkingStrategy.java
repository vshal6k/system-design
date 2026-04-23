package algomaster.problems.parkinglot.strategy.parking;

import java.util.List;
import java.util.Optional;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public interface ParkingStrategy {
    Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle);
}
