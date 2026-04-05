package algomaster.designpatterns.facade;

public class SmartHomeFacade {
    private Lights lights;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;

    public SmartHomeFacade(Lights lights, Thermostat thermostat, SecuritySystem securitySystem) {
        this.lights = lights;
        this.thermostat = thermostat;
        this.securitySystem = securitySystem;
    }

    public void leaveHome(){
        lights.turnOff();
        thermostat.setMode(ThermostatMode.ECO);
        securitySystem.arm();
    }

    public void arriveHome(){
        lights.turnOn();
        thermostat.setMode(ThermostatMode.COMFORT);
        securitySystem.disarm();
    }

    public static void main(String[] args) throws InterruptedException {
        SmartHomeFacade smartHomeFacade = new SmartHomeFacade(new Lights(), new Thermostat(), new SecuritySystem());
        smartHomeFacade.leaveHome();
        Thread.sleep(3000);
        smartHomeFacade.arriveHome();
    }
    
}
