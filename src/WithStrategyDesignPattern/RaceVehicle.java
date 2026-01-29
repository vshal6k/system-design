package WithStrategyDesignPattern;

import WithStrategyDesignPattern.DriveStrategies.SportsDriveStrategy;

public class RaceVehicle extends Vehicle{
    RaceVehicle(){
        super(new SportsDriveStrategy());
    }
}
