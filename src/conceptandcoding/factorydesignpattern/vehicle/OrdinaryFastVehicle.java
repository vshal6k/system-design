package factorydesignpattern.vehicle;

public class OrdinaryFastVehicle implements Vehicle{

    @Override
    public void move() {
        System.out.println("Ordinary fast vehicle is moving");
    }
    
}
