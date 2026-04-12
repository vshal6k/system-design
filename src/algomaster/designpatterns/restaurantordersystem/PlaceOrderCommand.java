package algomaster.designpatterns.restaurantordersystem;

public class PlaceOrderCommand implements Command{

    private Dish dish;
    private Kitchen kitchen;

    public PlaceOrderCommand(Dish dish, Kitchen kitchen) {
        this.dish = dish;
        this.kitchen = kitchen;
    }
    
    @Override
    public void execute() {
        this.kitchen.prepareDish(dish);
    }

    @Override
    public void undo() {
        this.kitchen.cancelDish(dish);
    }

    
}
