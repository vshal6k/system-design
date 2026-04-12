package algomaster.designpatterns.trafficlightcontroller;

public class TrafficLightRedState implements TrafficLightState{

    @Override
    public void change(TrafficLight context) {
        System.out.println("RED light - Stop");
        context.setTrafficLightState(new TrafficLightGreenState());
    }
    
}
