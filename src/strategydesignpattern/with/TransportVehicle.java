package WithStrategyDesignPattern;

import WithStrategyDesignPattern.DriveStrategies.SportsDriveStrategy;

public class TransportVehicle extends Vehicle{
    TransportVehicle(){
        super(new SportsDriveStrategy());
    }
}
