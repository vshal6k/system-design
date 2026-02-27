package factorydesignpattern.abstractfactory;

import factorydesignpattern.vehiclefactory.LuxuryFactory;
import factorydesignpattern.vehiclefactory.OrdinaryFactory;
import factorydesignpattern.vehiclefactory.VehicleFactory;

public class AbstractFactory {
    
    public VehicleFactory getVehicleFactory(String vehicleFactoryType){
        switch (vehicleFactoryType) {
            case "LUXURY":
                return new LuxuryFactory();
            case "ORDINARY":
                return new OrdinaryFactory();        
            default:
                throw new AssertionError("Pass correct vehicleFactoryType");
        }
    }
}
