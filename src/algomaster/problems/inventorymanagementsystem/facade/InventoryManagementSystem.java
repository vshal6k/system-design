package algomaster.problems.inventorymanagementsystem.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algomaster.problems.inventorymanagementsystem.entities.Product;
import algomaster.problems.inventorymanagementsystem.entities.StockTransfer;
import algomaster.problems.inventorymanagementsystem.entities.User;
import algomaster.problems.inventorymanagementsystem.entities.WareHouse;
import algomaster.problems.inventorymanagementsystem.enums.ProductCategory;
import algomaster.problems.inventorymanagementsystem.exception.LowStockException;
import algomaster.problems.inventorymanagementsystem.strategy.RestockStrategy;

public class InventoryManagementSystem {
    private Map<String, WareHouse> warehouses = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();
    private List<StockTransfer> stockTransfers = new ArrayList<>();
    public Map<String, WareHouse> getWarehouses() {
        return warehouses;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public List<StockTransfer> getStockTransfers() {
        return stockTransfers;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    private HashMap<String, User> users = new HashMap<>();

    public WareHouse addWareHouse(RestockStrategy restockStrategy) {
        WareHouse wareHouse = new WareHouse(restockStrategy);
        warehouses.putIfAbsent(wareHouse.getId(), wareHouse);
        return wareHouse;
    }

    public Product addProduct(String name, ProductCategory productCategory, BigDecimal price) {
        Product product = new Product(name, productCategory, price);
        products.putIfAbsent(product.getId(), product);
        return product;
    }

    public User addUser(String name) {
        User user = new User(name);
        users.putIfAbsent(user.getId(), user);
        return user;
    }

    public void addStock(String wareHouseId, String productId, Integer quantity) {
        WareHouse wareHouse = warehouses.get(wareHouseId);
        if (wareHouse == null)
            throw new IllegalArgumentException("Warehouse not found");

        Product product = products.get(productId);
        if (product == null)
            throw new IllegalArgumentException("Product not found");

        // add stock in warehouse
        wareHouse.addStock(productId, quantity);

        // record for audit
        StockTransfer stockTransfer = new StockTransfer(productId, null, wareHouseId, quantity);
        stockTransfers.add(stockTransfer);
    }

    public void removeStock(String wareHouseId, String productId, Integer quantity) throws LowStockException {
        WareHouse wareHouse = warehouses.get(wareHouseId);
        if (wareHouse == null)
            throw new IllegalArgumentException("Warehouse not found");

        Product product = products.get(productId);
        if (product == null)
            throw new IllegalArgumentException("Product not found");

        // remove stock from warehouse
        wareHouse.removeStock(productId, quantity);

        // record for audit
        StockTransfer stockTransfer = new StockTransfer(productId, wareHouseId, null, quantity);
        stockTransfers.add(stockTransfer);
    }

    public void transferStock(String sourceWareHouseId, String targetWareHouseId, String productId, Integer quantity)
            throws LowStockException {
        WareHouse sourceWareHouse = warehouses.get(sourceWareHouseId);
        if (sourceWareHouse == null)
            throw new IllegalArgumentException("Source warehouse not found");

        WareHouse targetWareHouse = warehouses.get(targetWareHouseId);
        if (targetWareHouse == null)
            throw new IllegalArgumentException("Target warehouse not found");

        Product product = products.get(productId);
        if (product == null)
            throw new IllegalArgumentException("Product not found");

        // remove stock from warehouse
        sourceWareHouse.removeStock(productId, quantity);

        // add stock from warehouse
        targetWareHouse.addStock(productId, quantity);

        // record for audit
        StockTransfer stockTransfer = new StockTransfer(productId, sourceWareHouseId, targetWareHouseId, quantity);
        stockTransfers.add(stockTransfer);
    }

    public void observeProduct(String wareHouseId, String productId, String userId) {
        WareHouse wareHouse = warehouses.get(wareHouseId);
        if (wareHouse == null)
            throw new IllegalArgumentException("Warehouse not found");

        User user = users.get(userId);
        if (user == null)
            throw new IllegalArgumentException("User not found");

        wareHouse.addStockObserver(productId, user);
    }

}
