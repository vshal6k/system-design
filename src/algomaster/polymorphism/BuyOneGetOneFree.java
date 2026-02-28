package algomaster.polymorphism;

public class BuyOneGetOneFree extends Discount{

    public BuyOneGetOneFree() {
        this.label = "Buy 1 Get 1 Free";
    }

    @Override
    public double apply(double price) {
        return price/2;
    }
    
}
