package myelevatorsystem;

import java.util.ArrayList;

public class Building {
    ArrayList<Floor> floors;
    ArrayList<ElevatorCar> elevatorCars;

    
    public int getBestElevatorForExternalRequest(int level, ExternalButtonState externalButtonState){
        //Use information of elevatorCars and come up with a elevatorCar to assign request
        return 0;
    }

    void handleExternalRequests(int level, ExternalButtonState externalButtonState){
        floors.get(level).externalButton.externalButtonState = externalButtonState;
        int bestElevator = getBestElevatorForExternalRequest(level, externalButtonState);
        elevatorCars.get(bestElevator).addPendingRequest(floors.get(level));
    };

    void handleInternalRequests(int elevatorCarIndex, int level){
        elevatorCars.get(elevatorCarIndex).internalButtons.get(level).pressed = true;
        elevatorCars.get(elevatorCarIndex).addPendingRequest(floors.get(level));
    };

}
