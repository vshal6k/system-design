package withstrategydesignpattern;

import withstrategydesignpattern.drivestrategies.SportsDriveStrategy;

public class TransportVehicle extends Vehicle{
    TransportVehicle(){
        super(new SportsDriveStrategy());
    }
}
