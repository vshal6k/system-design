package myelevatorsystem;

import myelevatorsystem.requests.*;

class InternalButton {
    public InternalRequest press(int destinationFloor) {
        return new InternalRequest(destinationFloor);
    }
}