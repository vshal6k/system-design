package factorydesignpattern;

import factorydesignpattern.abstractfactory.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AbstractFactory();

        abstractFactory.getVehicleFactory("LUXURY").getVehicle("SLOW").move();

        abstractFactory.getVehicleFactory("ORDINARY").getVehicle("FAST").move();

        abstractFactory.getVehicleFactory("LUXURY").getVehicle("FAST").move();

        abstractFactory.getVehicleFactory("ORDINARY").getVehicle("SLOW").move();
    }
}
