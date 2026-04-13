package algomaster.designpatterns.decorator.pizzatoppingsystem;

public class PlainPizza implements Pizza {
    private String description = "Plain Pizza";

    @Override
    public double getCost() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Plain pizza.";
    }
    
}
