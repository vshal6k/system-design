package myelevatorsystem;

import java.util.ArrayList;
import java.util.List;

import myelevatorsystem.requests.ExternalRequest;

public class Building {
    List<Floor> floors;
    ElevatorController controller;

    public Building(int numFloors, int numElevators) {
        floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i));
        }
        controller = new ElevatorController(numElevators);
    }

    public void handleExternalRequest(int floor, Direction direction) {
        controller.submitExternalRequest(new ExternalRequest(floor, direction));
    }

}
