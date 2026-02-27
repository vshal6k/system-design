package decoratordesignpattern.pizzawithtopping;

import decoratordesignpattern.pizza.BasePizza;

public class PizzaWithOlives extends PizzaWithTopping{

    public PizzaWithOlives(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return 20 + basePizza.cost();
    }
    
}
