package algomaster.designpatterns.restaurantordersystem;

public class Client {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Kitchen kitchen = new Kitchen();

        Dish paneer = new Dish("Paneer", "350");
        Dish roti = new Dish("Roti", "50");
        Dish fries = new Dish("Fries", "150");

        waiter.takeOrder(new PlaceOrderCommand(paneer, kitchen));
        waiter.takeOrder(new PlaceOrderCommand(fries, kitchen));
        waiter.takeOrder(new PlaceOrderCommand(roti, kitchen));

        waiter.submitOrders();
        
    }
}
