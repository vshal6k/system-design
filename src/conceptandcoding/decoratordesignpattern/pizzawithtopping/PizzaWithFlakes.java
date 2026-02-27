package decoratordesignpattern.pizzawithtopping;

import decoratordesignpattern.pizza.BasePizza;

public class PizzaWithFlakes extends PizzaWithTopping{

    public PizzaWithFlakes(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return 5 + basePizza.cost();
    }
    
}
