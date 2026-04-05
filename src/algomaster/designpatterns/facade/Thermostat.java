package algomaster.designpatterns.facade;

public class Thermostat {
    private ThermostatMode thermostatMode = ThermostatMode.ECO;

    public void setMode(ThermostatMode thermostatMode){
        System.out.println("Thermostat set to mode: " + thermostatMode.toString());
        this.thermostatMode = thermostatMode;
    }
}
