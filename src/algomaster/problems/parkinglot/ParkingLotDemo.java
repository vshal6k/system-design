package algomaster.problems.parkinglot;

import java.math.BigDecimal;
import java.util.Optional;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.enums.SpotSize;
import algomaster.problems.parkinglot.strategy.fee.VehicleBasedFeeStrategy;
import algomaster.problems.parkinglot.vehicle.Bike;
import algomaster.problems.parkinglot.vehicle.Car;
import algomaster.problems.parkinglot.vehicle.Truck;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        // 1. Initialize the parking lot with floors and spots
        Floor floor1 = new Floor(1);
        floor1.addSpot(new Spot(SpotSize.SMALL));
        floor1.addSpot(new Spot(SpotSize.MEDIUM));
        floor1.addSpot(new Spot(SpotSize.LARGE));

        Floor floor2 = new Floor(2);
        floor2.addSpot(new Spot(SpotSize.MEDIUM));
        floor2.addSpot(new Spot(SpotSize.MEDIUM));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        // 2. Simulate vehicle entries
        System.out.println("\n--- Vehicle Entries ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

        Vehicle bike = new Bike("B-123");
        Vehicle car = new Car("C-456");
        Vehicle truck = new Truck("T-789");

        Optional<Ticket> bikeTicketOpt = parkingLot.park(bike);

        Optional<Ticket> carTicketOpt = parkingLot.park(car);

        Optional<Ticket> truckTicketOpt = parkingLot.park(truck);

        System.out.println("\n--- Availability after parking ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

        // 3. Simulate another car entry (should go to floor 2)
        Vehicle car2 = new Car("C-999");
        Optional<Ticket> car2TicketOpt = parkingLot.park(car2);

        // 4. Simulate a vehicle entry that fails (no available spots)
        Vehicle bike2 = new Bike("B-000");
        Optional<Ticket> failedBikeTicketOpt = parkingLot.park(bike2);

        // 5. Simulate vehicle exits and fee calculation
        System.out.println("\n--- Vehicle Exits ---");

        if (carTicketOpt.isPresent()) {
            Optional<BigDecimal> feeOpt = parkingLot.unPark(car);
            feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        floor1.displayAvailability();
        floor2.displayAvailability();
    }
}
