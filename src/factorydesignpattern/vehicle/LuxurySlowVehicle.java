package factorydesignpattern.vehicle;

public class LuxurySlowVehicle implements Vehicle{

    @Override
    public void move() {
        System.out.println("Luxury slow vehicle is moving");
    }
    
}
