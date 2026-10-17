package algomaster.problems.inventorymanagementsystem.entities;

public interface StockObserver {
    void notifyForUpdate(String productId);
}
