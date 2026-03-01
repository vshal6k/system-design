package algomaster.aggregation.shoppingcartsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addItem(Product product) {
        if (!products.contains(product))
            products.add(product);
    }

    public void clearCart() {
        products.clear();
    }

    public double getTotal() {
        return products.stream().collect(Collectors.summingDouble(product -> product.getPrice()));
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getItemCount() {
        return products.size();
    }

}
