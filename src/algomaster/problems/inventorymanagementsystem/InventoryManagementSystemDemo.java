package algomaster.problems.inventorymanagementsystem;

import java.math.BigDecimal;

import algomaster.problems.inventorymanagementsystem.entities.Product;
import algomaster.problems.inventorymanagementsystem.entities.User;
import algomaster.problems.inventorymanagementsystem.entities.WareHouse;
import algomaster.problems.inventorymanagementsystem.enums.ProductCategory;
import algomaster.problems.inventorymanagementsystem.exception.LowStockException;
import algomaster.problems.inventorymanagementsystem.facade.InventoryManagementSystem;
import algomaster.problems.inventorymanagementsystem.strategy.ThresholdBasedRestockStrategy;

public class InventoryManagementSystemDemo {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // add products
        Product shirt = ims.addProduct("Shirt", ProductCategory.FASHION, BigDecimal.valueOf(2000));
        Product pant = ims.addProduct("Pant", ProductCategory.FASHION, BigDecimal.valueOf(3000));
        Product shoes = ims.addProduct("Shoes", ProductCategory.FOOTWEAR, BigDecimal.valueOf(1000));
        Product mobile = ims.addProduct("Mobile", ProductCategory.DIGITAL, BigDecimal.valueOf(50000));

        // add wareHouses
        WareHouse wareHouse1 = ims.addWareHouse(new ThresholdBasedRestockStrategy(5, 10));
        WareHouse wareHouse2 = ims.addWareHouse(new ThresholdBasedRestockStrategy(5, 1));
        WareHouse wareHouse3 = ims.addWareHouse(new ThresholdBasedRestockStrategy(5, 20));

        // add users
        User suresh = ims.addUser("Suresh");
        User ramesh = ims.addUser("Ramesh");
        User dinesh = ims.addUser("Dinesh");

        // add stock
        ims.addStock(wareHouse1.getId(), shirt.getId(), 10);
        ims.addStock(wareHouse1.getId(), pant.getId(), 10);
        ims.addStock(wareHouse2.getId(), shoes.getId(), 100);
        ims.addStock(wareHouse3.getId(), mobile.getId(), 40);

        // register observer
        ims.observeProduct(wareHouse1.getId(), shirt.getId(), suresh.getId());
        ims.observeProduct(wareHouse2.getId(), shoes.getId(), ramesh.getId());
        ims.observeProduct(wareHouse3.getId(), mobile.getId(), dinesh.getId());

        // check warehouse product quantities
        System.out.println("WareHouse 1: Stock Levels");
        wareHouse1.getStockLevels().values().forEach(value -> {
            System.out.println(value);
        });
        System.out.println("WareHouse 2: Stock Levels");
        wareHouse2.getStockLevels().values().forEach(value -> {
            System.out.println(value);
        });
        System.out.println("WareHouse 3: Stock Levels");
        wareHouse3.getStockLevels().values().forEach(value -> {
            System.out.println(value);
        });

        // add stock
        ims.addStock(wareHouse1.getId(), shirt.getId(), 23);
        System.out.println("WareHouse 1 After Stock Addition: Stock Levels");
        wareHouse1.getStockLevels().values().forEach(value -> {
            System.out.println(value);
        });

        // remove stock
        try {
            ims.removeStock(wareHouse1.getId(), shirt.getId(), 29);
        } catch (LowStockException e) {
             e.printStackTrace();
        }
        System.out.println("WareHouse 1 After Stock Removal: Stock Levels");
        wareHouse1.getStockLevels().values().forEach(value -> {
            System.out.println(value);
        });

        // remove stock, exception
        try {
            ims.removeStock(wareHouse1.getId(), shirt.getId(), 20);
        } catch (LowStockException e) {
            e.printStackTrace();
        }
        System.out.println("WareHouse 1 After Stock Removal: Stock Levels");
        wareHouse1.getStockLevels().values().forEach(value -> {
            System.out.println(value);
        });

        // audit
        System.out.println("Audit Records:");
        ims.getStockTransfers().stream().forEach(stockTransfer -> {
            System.out.println(stockTransfer.toString());
        });

    }
}
