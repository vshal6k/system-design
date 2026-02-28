package algomaster.polymorphism;

public class PercentageDiscount extends Discount{
    private double percentage;

    public PercentageDiscount(double percentage){
        this.percentage = percentage;
        this.label = String.valueOf(percentage) + "% off";
    }

    @Override
    public double apply(double price) {
        return Math.max(0, (price - (price*percentage)/100));
    }

}
