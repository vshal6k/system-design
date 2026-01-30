package factorydesignpattern.vehiclefactory;

import factorydesignpattern.vehicle.LuxuryFastVehicle;
import factorydesignpattern.vehicle.LuxurySlowVehicle;
import factorydesignpattern.vehicle.Vehicle;

public class LuxuryFactory implements VehicleFactory{

    public Vehicle getVehicle(String vehicleType){
        switch (vehicleType) {
            case "SLOW":
                return new LuxurySlowVehicle();
            case "FAST":
                return new LuxuryFastVehicle();        
            default:
                throw new AssertionError("Pass the correct vehicle type.");
        }
    }
}
