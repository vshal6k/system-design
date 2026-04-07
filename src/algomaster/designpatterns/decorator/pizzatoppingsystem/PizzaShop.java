package algomaster.designpatterns.decorator.pizzatoppingsystem;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza plainPizza = new PlainPizza();
        System.out.println(plainPizza.getCost() + " " + plainPizza.getDescription());

        Pizza plainPizzaWithMushroom = new MushroomDecorator(plainPizza);
        System.out.println(plainPizzaWithMushroom.getCost() + " " + plainPizzaWithMushroom.getDescription());

        Pizza plainPizzaWithMusroomAndCheese = new CheeseDecorator(plainPizzaWithMushroom);
        System.out.println(
                plainPizzaWithMusroomAndCheese.getCost() + " " + plainPizzaWithMusroomAndCheese.getDescription());

    }
}
