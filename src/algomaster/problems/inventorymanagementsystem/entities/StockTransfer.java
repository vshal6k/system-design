package algomaster.problems.inventorymanagementsystem.entities;

import java.time.LocalDateTime;

public class StockTransfer {
    private String productId;
    private String sourceWareHouseId;
    private String targetWareHouseId;
    private LocalDateTime createdAt;

    public String getProductId() {
        return productId;
    }

    public String getSourceWareHouseId() {
        return sourceWareHouseId;
    }

    public String getTargetWareHouseId() {
        return targetWareHouseId;
    }

    public StockTransfer(String productId, String sourceWareHouseId, String targetWareHouseId) {
        this.productId = productId;
        this.sourceWareHouseId = sourceWareHouseId;
        this.targetWareHouseId = targetWareHouseId;
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
