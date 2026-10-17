package algomaster.problems.inventorymanagementsystem.strategy;

public class ThresholdBasedRestockStrategy implements RestockStrategy {
    private int threshold;

    public ThresholdBasedRestockStrategy(int threshold, int restockValue) {
        this.threshold = threshold;
    }

    @Override
    public boolean shouldRestock(String productId, int quantity) {
        return (quantity < threshold);
    }

}
