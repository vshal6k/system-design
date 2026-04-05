package algomaster.designpatterns.adapter;

public class FahrenheitSensorAdapter implements Thermometer {

    private FahrenheitSensor fahrenheitSensor;

    public FahrenheitSensorAdapter(FahrenheitSensor fahrenheitSensor){
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemprature() {
        return (fahrenheitSensor.readFahrenheit() - 32) * 5/9;
    }

}
