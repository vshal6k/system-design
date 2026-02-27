package factorydesignpattern.vehiclefactory;

import factorydesignpattern.vehicle.OrdinaryFastVehicle;
import factorydesignpattern.vehicle.OrdinarySlowVehicle;
import factorydesignpattern.vehicle.Vehicle;

public class OrdinaryFactory implements VehicleFactory{

    public Vehicle getVehicle(String vehicleType){
        switch (vehicleType) {
            case "SLOW":
                return new OrdinarySlowVehicle();
            case "FAST":
                return new OrdinaryFastVehicle();      
            default:
                throw new AssertionError("Pass the correct vehicle type.");
        }
    }
}
