package algomaster.designpatterns.trafficlightcontroller;

public class TrafficLight {
    private TrafficLightState trafficLightState = new TrafficLightRedState();

    public TrafficLightState getTrafficLightState() {
        return trafficLightState;
    }

    public void setTrafficLightState(TrafficLightState trafficLightState) {
        this.trafficLightState = trafficLightState;
    }

    public void change(){
        this.trafficLightState.change(this);
    }

}
