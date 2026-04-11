package algomaster.designpatterns.weatherstation;

public class CurrentConditionsDisplay implements Observer{

    @Override
    public void update(Observable observable) {
        if(observable instanceof WeatherStation w){
            System.out.println("Current Temparature: " + w.getTemparature());
        }
    }
    
}
