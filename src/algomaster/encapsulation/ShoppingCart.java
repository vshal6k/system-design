package algomaster.encapsulation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private String discountCode;
    private boolean isCheckedOut;

    public void addItem(String name, double price) {
        if (!isCheckedOut) {
            this.items.put(name, price);
        }
    }

    public boolean applyDiscount(String code) {
        if ("SAVE10".equals(code) && this.discountCode == null) {
            this.discountCode = code;
            return true;
        } else {
            return false;
        }
    }

    public double getTotal() {
        double total = this.items.values().stream().collect(Collectors.summingDouble(d -> d));
        if(this.discountCode != null) total = (9 * total) / 10;
        return Math.round(100*total)/100.0;
    }

    public void checkout() {
        if (!items.isEmpty()) {
            this.isCheckedOut = true;
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("Total: $" + cart.getTotal()); // 1029.98

        System.out.println("Discount: " + cart.applyDiscount("SAVE10")); // true
        System.out.println("Total: $" + cart.getTotal()); // 926.98

        System.out.println("Discount: " + cart.applyDiscount("SAVE10")); // false (already applied)

        cart.checkout();
        cart.addItem("Keyboard", 79.99); // Should be rejected
        System.out.println("Total: $" + cart.getTotal()); // 926.98 (unchanged)
    }

}
