package algomaster.polymorphism;

public class OrderProcessor {

    public void processOrder(String item, double price, Discount discount) {
        System.out.print(item + "\t");
        discount.describe(price);
    }

    public static void main() {
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder("Books", 100, new FlatDiscount(10));
        orderProcessor.processOrder("Books", 100, new BuyOneGetOneFree());
        orderProcessor.processOrder("Books", 100, new PercentageDiscount(20));
    }
}
