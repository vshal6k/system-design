package factorydesignpattern.vehiclefactory;

import factorydesignpattern.vehicle.Vehicle;

public interface VehicleFactory {
    
    public Vehicle getVehicle(String vehicleType);
} 
