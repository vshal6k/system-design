package algomaster.problems.inventorymanagementsystem.entities;

import java.time.LocalDateTime;

public class StockTransfer {
    private String productId;
    private String sourceWareHouseId;
    private String targetWareHouseId;
    private LocalDateTime createdAt;
    private int quantity;

    public String getProductId() {
        return productId;
    }

    public String getSourceWareHouseId() {
        return sourceWareHouseId;
    }

    public String getTargetWareHouseId() {
        return targetWareHouseId;
    }

    public StockTransfer(String productId, String sourceWareHouseId, String targetWareHouseId, int quantity) {
        this.productId = productId;
        this.sourceWareHouseId = sourceWareHouseId;
        this.targetWareHouseId = targetWareHouseId;
        this.quantity = quantity;
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Stock Transfer, Product Id: " + productId + " From: " + sourceWareHouseId + " To: " + targetWareHouseId;
    }

}
