package myelevatorsystem.button;

import myelevatorsystem.Direction;
import myelevatorsystem.requests.*;

public class ExternalButton {
    public ExternalRequest pressUp(int floor) {
        return new ExternalRequest(floor, Direction.UP);
    }

    public ExternalRequest pressDown(int floor) {
        return new ExternalRequest(floor, Direction.DOWN);
    }
}