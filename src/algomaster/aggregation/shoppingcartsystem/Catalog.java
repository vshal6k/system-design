package algomaster.aggregation.shoppingcartsystem;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Product> products = new ArrayList<>();

    public Product findByName(String name){
        return products.stream().filter(product -> product.getName().equals(name)).findFirst().orElseGet(null);
    }

    public void addProduct(Product product){
        if(!products.contains(product)) products.add(product);
    }

    public int getProductCount() {
        return products.size();
    }

}
