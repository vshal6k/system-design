package myelevatorsystem;

import java.util.ArrayList;

public class ElevatorCar {
    ArrayList<InternalButton> internalButtons;
    ArrayList<Floor> pendingFloorReqeusts;
    Floor currentFloor;
    Direction direction;

    public void setCurrentFloor(Floor curentFloor) {
        this.currentFloor = curentFloor;
    }

    public void addPendingRequest(Floor floor) {
        pendingFloorReqeusts.add(floor);
        if (pendingFloorReqeusts.size() != 0)
            this.processPendingRequests();
    }

    public void processPendingRequests() {
        processRequest(pendingFloorReqeusts.get(0));
        pendingFloorReqeusts.remove(0);
        if (pendingFloorReqeusts.size() != 0)
            this.processPendingRequests();
    }

    private void updateDirection(Floor destinationFloor) {
        if (this.currentFloor.level == destinationFloor.level) {
            this.direction = Direction.IDLE;
        } else if (this.currentFloor.level < destinationFloor.level) {
            this.direction = Direction.UP;
        } else
            this.direction = Direction.DOWN;
    }

    public void processRequest(Floor destinationFloor) {
        updateDirection(destinationFloor);

        // take some time to move

        setCurrentFloor(destinationFloor);
        updateDirection(destinationFloor);

        InternalButton internalButton = internalButtons.get(destinationFloor.level);
        if (internalButton.pressed)
            internalButton.pressed = false;
        ExternalButton externalButton = destinationFloor.externalButton;
        externalButton.externalButtonState = ExternalButtonState.NOT_PRESSED;
    }

}
