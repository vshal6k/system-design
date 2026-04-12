package algomaster.designpatterns.restaurantordersystem;

public class CancelOrderCommand implements Command{

    private Kitchen kitchen;
    private Dish dish;

    

    public CancelOrderCommand(Kitchen kitchen, Dish dish) {
        this.kitchen = kitchen;
        this.dish = dish;
    }

    @Override
    public void execute() {
        this.kitchen.cancelDish(dish);
    }

    @Override
    public void undo() {
        this.kitchen.prepareDish(dish);
    }
    
}
