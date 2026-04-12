package algomaster.designpatterns.restaurantordersystem;

public class Kitchen {

    public void prepareDish(Dish dish){
        System.out.println("Preparing Dish: " + dish.getName());
    }

    public void cancelDish(Dish dish){
        System.out.println("Cancelling Dish: " + dish.getName());
    }
}
