package algomaster.enums;

import java.time.Duration;

public enum TrafficLight {
    RED("Red", Duration.ofSeconds(30)), GREEN("Green", Duration.ofSeconds(25)), YELLOW("Yellow", Duration.ofSeconds(5));

    private final String color;
    private final Duration duration;

    private TrafficLight(String color, Duration duration) {
        this.color = color;
        this.duration = duration;
    }

    public void display() {
        System.out.println("Color: " + this.color + " Duration: " + this.duration.toSeconds());
    }

    public TrafficLight next() {
        return (switch (this) {
            case RED -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        });
    }

    public static void main(String[] args) {
        TrafficLight.RED.display();
        TrafficLight.GREEN.display();
        TrafficLight.YELLOW.display();

        System.out.println(TrafficLight.RED.next());
        System.out.println(TrafficLight.GREEN.next());
        System.out.println(TrafficLight.YELLOW.next());

        TrafficLight light = TrafficLight.RED;
        for (int i = 0; i < 6; i++) {
            light.display();  // Should show color and duration
            light = light.next();
        }

    }

}
