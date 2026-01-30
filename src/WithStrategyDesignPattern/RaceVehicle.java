package withstrategydesignpattern;

import withstrategydesignpattern.drivestrategies.SportsDriveStrategy;

public class RaceVehicle extends Vehicle{
    RaceVehicle(){
        super(new SportsDriveStrategy());
    }
}
