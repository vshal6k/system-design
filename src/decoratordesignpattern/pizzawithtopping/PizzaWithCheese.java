package decoratordesignpattern.pizzawithtopping;

import decoratordesignpattern.pizza.BasePizza;

public class PizzaWithCheese extends PizzaWithTopping{

    public PizzaWithCheese(BasePizza basePizza){
        super(basePizza);
    }
    
    @Override
    public int cost() {
        return 10 + basePizza.cost();
    }
    
}
