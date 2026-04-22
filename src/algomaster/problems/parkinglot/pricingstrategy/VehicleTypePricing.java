package algomaster.problems.parkinglot.pricingstrategy;

import java.math.BigDecimal;

import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.domainmodel.Vehicle;
import algomaster.problems.parkinglot.enums.VehicleType;

public class VehicleTypePricing implements PricingStrategy {

    @Override
    public BigDecimal calculate(Ticket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        BigDecimal price;

        switch (vehicle.getVehicleType()) {
            case BIKE:
                price = BigDecimal.TEN;
                break;
            case CAR:
                price = BigDecimal.TEN.multiply(BigDecimal.TWO);
                break;
            case TRUCK:
                price = BigDecimal.TEN.multiply(BigDecimal.TEN);
                break;
            default:
                price = null;
        }

        return price;
    }

}
