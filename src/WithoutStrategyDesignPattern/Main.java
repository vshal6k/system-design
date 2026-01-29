package WithoutStrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle;

        vehicle = new Vehicle();
        vehicle.drive();

        vehicle = new TransportVehicle();
        vehicle.drive();

        vehicle = new PublicTransportVehicle();
        vehicle.drive();

        vehicle = new RaceVehicle();
        vehicle.drive();
    }
}
