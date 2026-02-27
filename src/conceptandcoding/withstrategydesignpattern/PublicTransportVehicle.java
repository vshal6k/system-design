package withstrategydesignpattern;

import withstrategydesignpattern.drivestrategies.NormalDriveStrategy;

public class PublicTransportVehicle extends Vehicle{
    
    PublicTransportVehicle(){
        super(new NormalDriveStrategy());
    }
}
