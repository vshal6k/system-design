package algomaster.problems.parkinglot.strategy.fee;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

import algomaster.problems.parkinglot.domainmodel.Ticket;
import algomaster.problems.parkinglot.enums.VehicleSize;
import algomaster.problems.parkinglot.vehicle.Vehicle;

public class VehicleBasedFeeStrategy implements FeeStrategy {

    private static final Map<VehicleSize, BigDecimal> HOURLY_RATES = Map.of(
            VehicleSize.SMALL, BigDecimal.valueOf(10.0),
            VehicleSize.MEDIUM, BigDecimal.valueOf(20.0),
            VehicleSize.LARGE, BigDecimal.valueOf(30.0));

    @Override
    public BigDecimal calculate(Ticket ticket) {
        LocalDateTime startTime = ticket.getEntryTime();
        LocalDateTime endTime = ticket.getExitTime();

        long seconds = Duration.between(startTime, endTime).toSeconds();

        Vehicle vehicle = ticket.getVehicle();
        BigDecimal price = HOURLY_RATES.get(vehicle.getSize()).multiply(BigDecimal.valueOf(seconds));

        return price;
    }

}
