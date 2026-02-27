package decoratordesignpattern.pizzastore;

import decoratordesignpattern.pizza.BasePizza;
import decoratordesignpattern.pizza.Margherita;
import decoratordesignpattern.pizza.PeppyPaneer;
import decoratordesignpattern.pizzawithtopping.PizzaWithCheese;
import decoratordesignpattern.pizzawithtopping.PizzaWithOlives;

public class PizzaStore {
    public static void main(String[] args) {
        BasePizza myPizza = new PizzaWithCheese(new PizzaWithOlives(new Margherita()));
        System.out.println(myPizza.cost());

        BasePizza kananPizza = new PizzaWithCheese(new PeppyPaneer());
        System.out.println(kananPizza.cost());
    }
}
