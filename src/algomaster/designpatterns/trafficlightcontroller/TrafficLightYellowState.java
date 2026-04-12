package algomaster.designpatterns.trafficlightcontroller;

public class TrafficLightYellowState implements TrafficLightState{

    @Override
    public void change(TrafficLight context) {
        System.out.println("YELLOW light - Slow down");
        context.setTrafficLightState(new TrafficLightRedState());
    }

}
