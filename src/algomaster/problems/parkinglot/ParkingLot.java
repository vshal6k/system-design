package algomaster.problems.parkinglot;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.strategy.fee.FeeStrategy;
import algomaster.problems.parkinglot.strategy.parking.ParkingStrategy;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class ParkingLot {
    private static volatile ParkingLot INSTANCE;
    private final List<Floor> floors = new CopyOnWriteArrayList<>();
    private Map<String, Ticket> vehicleTicketMap = new ConcurrentHashMap<>();
    private final ParkingStrategy parkingStrategy;
    private final FeeStrategy feeStrategy;

    private ParkingLot(ParkingStrategy parkingStrategy, FeeStrategy feeStrategy) {
        this.parkingStrategy = parkingStrategy;
        this.feeStrategy = feeStrategy;
    }

    public static ParkingLot getInstance(ParkingStrategy parkingStrategy, FeeStrategy feeStrategy) {
        if (ParkingLot.INSTANCE == null) {
            synchronized (ParkingLot.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ParkingLot(parkingStrategy, feeStrategy);
                }
            }
        }
        return INSTANCE;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public synchronized Optional<Ticket> park(Vehicle vehicle) {

        if (vehicleTicketMap.get(vehicle.getId()) != null)
            throw new IllegalArgumentException("Vehicle is already parked");

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

}
