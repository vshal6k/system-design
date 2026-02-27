package myelevatorsystem.requests;

import myelevatorsystem.Direction;

public class ExternalRequest {
    public int floor;
    public Direction direction;

    public ExternalRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}
