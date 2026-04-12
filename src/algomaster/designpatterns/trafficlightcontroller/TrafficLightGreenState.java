package algomaster.designpatterns.trafficlightcontroller;

public class TrafficLightGreenState implements TrafficLightState{

    @Override
    public void change(TrafficLight context) {
        System.out.println("GREEN light - Go");
        context.setTrafficLightState(new TrafficLightYellowState());
    }

}
