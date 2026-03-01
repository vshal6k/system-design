package algomaster.aggregation.shoppingcartsystem;

public class Main {
    public static void main(String[] args) {
        Product iPhone = new Product("iPhone", 20);
        Product laptop = new Product("Laptop", 100);
        Product car = new Product("Verna", 20000);
        Product bike = new Product("Peslendor", 4000);

        Catalog digitalProductCatalog = new Catalog();
        digitalProductCatalog.addProduct(iPhone);
        digitalProductCatalog.addProduct(laptop);

        Catalog vehicleProductCatalog = new Catalog();
        vehicleProductCatalog.addProduct(bike);
        vehicleProductCatalog.addProduct(car);

        Cart cart1 = new Cart();
        cart1.addItem(bike);
        cart1.addItem(iPhone);
        
        Cart cart2 = new Cart();
        cart2.addItem(car);
        cart2.addItem(laptop);
        
        Customer alice = new Customer("Alice", cart1);
        Customer bob = new Customer("Bob", cart2);

        System.out.println("Alice's cart: " + cart1.getItemCount() + " items, $" + cart1.getTotal());
        System.out.println("Bob's cart: " + cart2.getItemCount() + " items, $" + cart2.getTotal());

        alice.checkout();

        // After Alice checks out, products still exist
        System.out.println("Catalog still has " + vehicleProductCatalog.getProductCount() + " products");
        System.out.println("Bob's cart still has " + cart2.getItemCount() + " items");
        System.out.println("Laptop still exists: " + laptop.getName());

    }
}
