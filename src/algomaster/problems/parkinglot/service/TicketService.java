package algomaster.problems.parkinglot.service;

import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.domainmodel.Vehicle;

//Responsible for creating tickets
public class TicketService {
    private ConcurrentHashMap<String, Ticket> vehicleTicketMap = new ConcurrentHashMap<>();

    public Ticket getTicketForVehicle(Vehicle vehicle) {
        Ticket ticket = vehicleTicketMap.get(vehicle.getId());
        if (ticket == null)
            throw new IllegalArgumentException("Ticket not found");

        return ticket;
    }

    public void generate(Vehicle vehicle, Spot spot) {
        Ticket ticket = new Ticket(vehicle, spot);
        vehicleTicketMap.put(vehicle.getId(), ticket);
    }

    public Ticket closeTicket(Vehicle vehicle) {
        Ticket ticket = getTicketForVehicle(vehicle);
        ticket.setExitTime();
        return ticket;
    }

}
