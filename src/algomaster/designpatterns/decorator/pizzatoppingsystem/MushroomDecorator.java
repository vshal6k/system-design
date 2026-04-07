package algomaster.designpatterns.decorator.pizzatoppingsystem;

public class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(Pizza basePizza) {
        super(basePizza);
    }

    @Override
    public double getCost() {
        return super.basePizza.getCost() + 1.00;
    }

    @Override
    public String getDescription() {
        return super.basePizza.getDescription() + " " + "+ Mushroom";
    }
}
