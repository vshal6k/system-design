package algomaster.polymorphism;

public class FlatDiscount extends Discount{
    private double amount;

    public FlatDiscount(double amount){
        this.amount = amount;
        this.label = "$" + String.valueOf(amount) + " off";
    }

    @Override
    public double apply(double price) {
        return Math.max(0, price - amount);
    }
    
}
