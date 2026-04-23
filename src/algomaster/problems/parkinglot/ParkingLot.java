package algomaster.problems.parkinglot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.strategy.fee.FeeStrategy;
import algomaster.problems.parkinglot.strategy.fee.FlatRateFeeStrategy;
import algomaster.problems.parkinglot.strategy.parking.BestFitStrategy;
import algomaster.problems.parkinglot.strategy.parking.ParkingStrategy;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class ParkingLot {
    private static ParkingLot INSTANCE;
    private final List<Floor> floors = Collections.synchronizedList(new ArrayList<>());
    private Map<String, Ticket> vehicleTicketMap = new ConcurrentHashMap<>();
    private ParkingStrategy parkingStrategy;
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        this.parkingStrategy = new BestFitStrategy();
        this.feeStrategy = new FlatRateFeeStrategy();
    }

    public static ParkingLot getInstance() {
        if (ParkingLot.INSTANCE == null) {
            synchronized (ParkingLot.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ParkingLot();
                }
            }
        }
        return INSTANCE;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public synchronized Optional<Ticket> park(Vehicle vehicle) {
        Optional<Spot> availableSpot = parkingStrategy.findSpot(floors, vehicle);
        if (availableSpot.isEmpty()) {
            System.out.println("No spots available for the vehicle.");
            return Optional.empty();
        }

        Spot spot = availableSpot.get();
        spot.park(vehicle);
        Ticket ticket = new Ticket(vehicle, spot);
        vehicleTicketMap.put(vehicle.getId(), ticket);
        System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getId(), spot.getSpotId(),
                ticket.getId());
        return Optional.of(ticket);

    }

    public synchronized Optional<BigDecimal> unPark(Vehicle vehicle) {
        Ticket ticket = vehicleTicketMap.get(vehicle.getId());
        if (ticket == null)
            throw new IllegalArgumentException("Ticet not found for the vehicle");

        vehicleTicketMap.remove(vehicle.getId());
        Spot spot = ticket.getSpot();
        spot.unPark();
        ticket.setExitTime();
        BigDecimal fee = feeStrategy.calculate(ticket);
        return Optional.of(fee);
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

}
