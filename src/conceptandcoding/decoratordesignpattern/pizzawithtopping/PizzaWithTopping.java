package decoratordesignpattern.pizzawithtopping;

import decoratordesignpattern.pizza.BasePizza;

public abstract class PizzaWithTopping extends BasePizza{
    public BasePizza basePizza;

    public PizzaWithTopping(BasePizza basePizza){
        this.basePizza = basePizza;
    }
}
