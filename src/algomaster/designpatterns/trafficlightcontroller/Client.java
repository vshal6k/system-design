package algomaster.designpatterns.trafficlightcontroller;

public class Client {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.change();
        trafficLight.change();
        trafficLight.change();
        trafficLight.change();
    }
}
