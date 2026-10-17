package algomaster.problems.inventorymanagementsystem.entities;

import java.util.UUID;

public class User implements StockObserver {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void notifyForUpdate(String productId) {
        System.out.println("Hello " + name + ", Product with id " + productId + " is low on stock.");
    }

}
