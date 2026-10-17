package algomaster.problems.inventorymanagementsystem.entities;

import java.math.BigDecimal;
import java.util.UUID;

import algomaster.problems.inventorymanagementsystem.enums.ProductCategory;

public class Product {
    private String id;
    private String name;
    private ProductCategory category;
    private BigDecimal price;

    public Product(String name, ProductCategory category, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
