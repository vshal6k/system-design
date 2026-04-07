package algomaster.designpatterns.decorator.pizzatoppingsystem;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza basePizza) {
        super(basePizza);
    }

    @Override
    public double getCost() {
        return super.basePizza.getCost() + 1.50;
    }

    @Override
    public String getDescription() {
        return super.basePizza.getDescription() + " " + "+ Cheese";
    }

}
