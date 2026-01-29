package WithStrategyDesignPattern;

import WithStrategyDesignPattern.DriveStrategies.NormalDriveStrategy;

public class PublicTransportVehicle extends Vehicle{
    
    PublicTransportVehicle(){
        super(new NormalDriveStrategy());
    }
}
