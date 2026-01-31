package myelevatorsystem.button;

import myelevatorsystem.requests.*;

public class InternalButton {
    public InternalRequest press(int destinationFloor) {
        return new InternalRequest(destinationFloor);
    }
}