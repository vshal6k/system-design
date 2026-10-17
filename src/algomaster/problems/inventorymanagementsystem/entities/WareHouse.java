package algomaster.problems.inventorymanagementsystem.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import algomaster.problems.inventorymanagementsystem.exception.LowStockException;
import algomaster.problems.inventorymanagementsystem.strategy.RestockStrategy;

public class WareHouse {
    private String id;
    private Map<String, Integer> stockLevels = new HashMap<>();
    private List<StockObserver> stockObservers = new ArrayList<>();
    private RestockStrategy restockStrategy;

    public WareHouse(RestockStrategy restockStrategy) {
        this.id = UUID.randomUUID().toString();
        this.restockStrategy = restockStrategy;
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getStockLevels() {
        return stockLevels;
    }

    public List<StockObserver> getStockObservers() {
        return stockObservers;
    }

    public RestockStrategy getRestockStrategy() {
        return restockStrategy;
    }

    public void addStock(String productId, Integer quantity) {
        stockLevels.putIfAbsent(productId, 0);
        Integer currentQuantity = stockLevels.get(productId);
        stockLevels.put(productId, currentQuantity + quantity);
    }

    public void removeStock(String productId, Integer quantity) throws LowStockException {
        Integer currentQuantity = stockLevels.getOrDefault(productId, 0);

        // throw an error if current quantity is not sufficient
        if (currentQuantity < quantity)
            throw new LowStockException("Product with " + productId + " is not available in sufficient quantity.");

        stockLevels.put(productId, currentQuantity - quantity);

        // check if restock is needed
        boolean isRestockNeeded = restockStrategy.shouldRestock(productId, currentQuantity - quantity);

        if (isRestockNeeded) {
            // notify observers that restock is needed
            stockObservers.stream().forEach(stockObserver -> {
                stockObserver.notifyForUpdate(productId);
            });
        }

    }

    public void addStockObserver(String productId, StockObserver stockObserver) {
        stockObservers.add(stockObserver);
    }

}
