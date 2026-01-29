package WithStrategyDesignPattern;

import WithStrategyDesignPattern.DriveStrategies.DriveStrategy;
import WithStrategyDesignPattern.DriveStrategies.NormalDriveStrategy;

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
