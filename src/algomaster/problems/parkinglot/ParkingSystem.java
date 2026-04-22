package algomaster.problems.parkinglot;

import java.math.BigDecimal;
import java.util.List;

import algomaster.problems.parkinglot.domainmodel.Lot;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.domainmodel.Vehicle;
import algomaster.problems.parkinglot.enums.SpotSize;
import algomaster.problems.parkinglot.pricingstrategy.PricingStrategy;
import algomaster.problems.parkinglot.service.BillingService;
import algomaster.problems.parkinglot.service.SpotManagementService;
import algomaster.problems.parkinglot.service.TicketService;

//Facade to hide the internal complexity of the system
public class ParkingSystem {
    private final SpotManagementService spotManagementService;
    private final TicketService ticketService;
    private final BillingService billingService;

    public ParkingSystem(Lot lot, PricingStrategy pricingStrategy) {
        this.spotManagementService = new SpotManagementService(lot);
        this.ticketService = new TicketService();
        this.billingService = new BillingService(pricingStrategy);
    }

    // Parks vehicle automatically to an assigned slot or throws exception
    public void park(Vehicle vehicle) {
        Spot spot = spotManagementService.park(vehicle);
        ticketService.generate(vehicle, spot);
        System.out.println("Vehicle is parked");

    }

    // Unparks the given vehicle and prints the payable amount
    public void unPark(Vehicle vehicle) {
        spotManagementService.unPark(vehicle);
        Ticket ticket = ticketService.closeTicket(vehicle);
        BigDecimal payableAmount = billingService.calculateCharge(ticket);
        System.out.println("Vehicle is unparked. Please pay: " + payableAmount);
    }

    // Returns available spots of a given floor
    public List<Spot> filterAvailableSpotByFloor(int floorNumber) {
        return spotManagementService.filterAvailableSpotByFloor(floorNumber);
    }

    // Returns available spots of a given size
    public List<Spot> filterAvailableSpotBySize(SpotSize spotSize) {
        return spotManagementService.filterAvailableSpotBySize(spotSize);
    }

    // Displays available spots of a given floor
    public void displayAvailableSpotByFloor(int floorNumber) {
        spotManagementService.displayAvailableSpotByFloor(floorNumber);
    }

    // Displays available spots of a given size
    public void displayAvailableSpotBySize(SpotSize spotSize) {
        spotManagementService.displayAvailableSpotBySize(spotSize);
    }

}
