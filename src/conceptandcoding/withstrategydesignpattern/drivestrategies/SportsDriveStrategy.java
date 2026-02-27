package withstrategydesignpattern.drivestrategies;

public class SportsDriveStrategy implements DriveStrategy{
    public void drive() {
        System.out.println("Driving");
        System.out.println("Sports mode turned on for more speed");
    }
}
