package algomaster.designpatterns.decorator.pizzatoppingsystem;

public class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza basePizza) {
        super(basePizza);
    }

    @Override
    public double getCost() {
        return super.basePizza.getCost() + 2.00;
    }

    @Override
    public String getDescription() {
        return super.basePizza.getDescription() + " " + "+ Pepperoni";
    }
}
