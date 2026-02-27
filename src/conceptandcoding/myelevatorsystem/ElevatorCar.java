package myelevatorsystem;

import myelevatorsystem.requests.*;
import java.util.TreeSet;
import java.util.Collections;

class ElevatorCar {
    int id;
    int currentFloor;
    Direction direction;
    ElevatorState state;

    TreeSet<Integer> upRequests = new TreeSet<>();
    TreeSet<Integer> downRequests = new TreeSet<>(Collections.reverseOrder());

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void addExternalRequest(ExternalRequest request) {
        if (request.direction == Direction.UP)
            upRequests.add(request.floor);
        else
            downRequests.add(request.floor);
        updateState();
    }

    public void addInternalRequest(InternalRequest request) {
        if (request.destinationFloor > currentFloor)
            upRequests.add(request.destinationFloor);
        else
            downRequests.add(request.destinationFloor);
        updateState();
    }

    private void updateState() {
        if (!upRequests.isEmpty() || !downRequests.isEmpty()) {
            state = ElevatorState.MOVING;
            if (direction == Direction.IDLE) {
                direction = !upRequests.isEmpty() ? Direction.UP : Direction.DOWN;
            }
        }
    }

    // Simulates ONE STEP of elevator movement
    public void step() {
        if (state == ElevatorState.IDLE)
            return;

        if (direction == Direction.UP)
            currentFloor++;
        else if (direction == Direction.DOWN)
            currentFloor--;

        checkStop();
    }

    private void checkStop() {
        if (direction == Direction.UP && upRequests.contains(currentFloor)) {
            upRequests.remove(currentFloor);
            openDoors();
        } else if (direction == Direction.DOWN && downRequests.contains(currentFloor)) {
            downRequests.remove(currentFloor);
            openDoors();
        }

        if (upRequests.isEmpty() && downRequests.isEmpty()) {
            state = ElevatorState.IDLE;
            direction = Direction.IDLE;
        } else if (direction == Direction.UP && upRequests.isEmpty()) {
            direction = Direction.DOWN;
        } else if (direction == Direction.DOWN && downRequests.isEmpty()) {
            direction = Direction.UP;
        }
    }

    private void openDoors() {
        state = ElevatorState.DOORS_OPEN;
        // simulate door delay
        state = ElevatorState.MOVING;
    }
}
