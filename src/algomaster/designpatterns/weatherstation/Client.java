package algomaster.designpatterns.weatherstation;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        weatherStation.registerObserver(currentConditionsDisplay);
        weatherStation.setTemparature(10);
        Thread.sleep(1000);
        weatherStation.setTemparature(20);
        Thread.sleep(1000);
        weatherStation.setTemparature(30);
        Thread.sleep(1000);
        weatherStation.setTemparature(100);

    }
}
