package algomaster.problems.inventorymanagementsystem.strategy;

public interface RestockStrategy {
    boolean shouldRestock(String productId, int quantity);
}
