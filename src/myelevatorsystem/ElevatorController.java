package myelevatorsystem;

import java.util.List;
import java.util.ArrayList;
import myelevatorsystem.requests.ExternalRequest;

class ElevatorController {
    List<ElevatorCar> elevators;

    public ElevatorController(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new ElevatorCar(i));
        }
    }

    public void submitExternalRequest(ExternalRequest request) {
        ElevatorCar best = findBestElevator(request);
        best.addExternalRequest(request);
    }

    private ElevatorCar findBestElevator(ExternalRequest request) {
        ElevatorCar best = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorCar e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - request.floor);

            if (e.getState() == ElevatorState.IDLE && distance < minDistance) {
                best = e;
                minDistance = distance;
            }
        }

        return best != null ? best : elevators.get(0); // fallback
    }
}
