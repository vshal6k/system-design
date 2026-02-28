package algomaster.polymorphism;

public abstract class Discount {
    protected String label;

    public abstract double apply(double price);

    public void describe(double originalPrice){
        double discountedPrice = apply(originalPrice);
        System.out.printf("%s: $%.2f -> $%.2f\n", this.label, originalPrice, discountedPrice);
    }
}
