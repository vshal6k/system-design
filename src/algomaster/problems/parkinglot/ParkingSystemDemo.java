package algomaster.problems.parkinglot;

import java.util.ArrayList;
import java.util.List;

import algomaster.problems.parkinglot.domainmodel.Floor;
import algomaster.problems.parkinglot.domainmodel.Lot;
import algomaster.problems.parkinglot.domainmodel.Spot;
import algomaster.problems.parkinglot.domainmodel.Vehicle;
import algomaster.problems.parkinglot.enums.SpotSize;
import algomaster.problems.parkinglot.enums.VehicleType;
import algomaster.problems.parkinglot.pricingstrategy.FlatRatePricing;
import algomaster.problems.parkinglot.pricingstrategy.VehicleTypePricing;

public class ParkingSystemDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Spot> spotsFirstFloor = new ArrayList<>();
        List<Spot> spotsSecondFloor = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            spotsFirstFloor.add(new Spot(SpotSize.SMALL));
            spotsSecondFloor.add(new Spot(SpotSize.SMALL));
        }
        for (int i = 0; i < 1; i++) {
            spotsFirstFloor.add(new Spot(SpotSize.MEDIUM));
            spotsSecondFloor.add(new Spot(SpotSize.MEDIUM));
        }
        for (int i = 0; i < 1; i++) {
            spotsFirstFloor.add(new Spot(SpotSize.LARGE));
            spotsSecondFloor.add(new Spot(SpotSize.LARGE));
        }

        Floor firstFloor = new Floor(spotsFirstFloor);
        Floor secondFloor = new Floor(spotsSecondFloor);

        List<Floor> floors = List.of(firstFloor, secondFloor);

        Lot lot = new Lot(floors);

        ParkingSystem parkingSystem = new ParkingSystem(lot, new FlatRatePricing());

        Vehicle bike = new Vehicle(VehicleType.BIKE);
        Vehicle meteor = new Vehicle(VehicleType.BIKE);
        Vehicle triumph = new Vehicle(VehicleType.BIKE);
        Vehicle car = new Vehicle(VehicleType.CAR);
        Vehicle truck = new Vehicle(VehicleType.TRUCK);

        parkingSystem.displayAvailableSpotByFloor(0);
        parkingSystem.displayAvailableSpotByFloor(1);

        parkingSystem.park(bike);
        parkingSystem.park(meteor);
        // parkingSystem.park(triumph);
        // Thread.sleep(2000);
        // parkingSystem.unPark(bike);

        parkingSystem.park(truck);
        // Thread.sleep(3000);
        // parkingSystem.unPark(truck);

        parkingSystem.park(car);
        // Thread.sleep(4000);
        // parkingSystem.unPark(car);
        parkingSystem.unPark(bike);

        parkingSystem.displayAvailableSpotByFloor(0);
        parkingSystem.displayAvailableSpotByFloor(1);

        // ParkingSystem parkingSystem2 = new ParkingSystem(lot, new
        // VehicleTypePricing());

        // parkingSystem2.park(bike);
        // parkingSystem2.unPark(bike);

        // parkingSystem2.park(truck);
        // parkingSystem2.unPark(truck);

        // parkingSystem2.park(car);
        // parkingSystem2.unPark(car);

        // parkingSystem.park(truck);
        // parkingSystem.park(truck);

        // parkingSystem.unPark(truck);

        // List<Spot> smallSpots = new ArrayList<>();

        // for (int i = 0; i < 5; i++) {
        // smallSpots.add(new Spot(SpotSize.SMALL));
        // }

        // Floor smallFloor = new Floor(smallSpots);

        // List<Floor> smallFloors = List.of(smallFloor);

        // Lot smallLot = new Lot(smallFloors);

        // ParkingSystem smallParkingSystem = new ParkingSystem(smallLot, new
        // FlatRatePricing());

        // Vehicle pikkanTruck = new Vehicle(VehicleType.TRUCK);
        // Vehicle hunter = new Vehicle(VehicleType.BIKE);

        // smallParkingSystem.park(hunter);
        // // smallParkingSystem.park(pikkanTruck);
        // Thread.sleep(1000);
        // smallParkingSystem.unPark(hunter);

    }
}
