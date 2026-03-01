package algomaster.aggregation.shoppingcartsystem;

public class Customer {
    private String name;
    private Cart cart;

    public Customer(String name, Cart cart) {
        this.name = name;
        this.cart = cart;
    }

    public void checkout(){
        System.out.println("Cart Content:");
        this.cart.getProducts().stream().forEach(product -> System.out.println(product.getName() + " " + product.getPrice()));
        System.out.println("Total: " + cart.getTotal());
        this.cart.clearCart();
    }
}
