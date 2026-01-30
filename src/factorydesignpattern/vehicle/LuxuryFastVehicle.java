package factorydesignpattern.vehicle;

public class LuxuryFastVehicle implements Vehicle{

    @Override
    public void move() {
        System.out.println("Luxury fast vehicle is moving");
    }
    
}
