package algomaster.designpatterns.decorator.pizzatoppingsystem;

public abstract class PizzaDecorator implements Pizza {
    protected Pizza basePizza;

    public PizzaDecorator(Pizza basePizza) {
        this.basePizza = basePizza;
    }
}
