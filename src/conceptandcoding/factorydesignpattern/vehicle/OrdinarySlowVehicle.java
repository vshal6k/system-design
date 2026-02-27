package factorydesignpattern.vehicle;

public class OrdinarySlowVehicle implements Vehicle{

    @Override
    public void move() {
        System.out.println("Ordinary slow vehicle is moving");
    }
    
}
