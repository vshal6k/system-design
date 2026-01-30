package withstrategydesignpattern;

import withstrategydesignpattern.drivestrategies.DriveStrategy;
import withstrategydesignpattern.drivestrategies.NormalDriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    Vehicle(){
        this.driveStrategy = new NormalDriveStrategy();
    }

    Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        this.driveStrategy.drive();
    }
}
