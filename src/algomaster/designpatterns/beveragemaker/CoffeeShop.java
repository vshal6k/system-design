package algomaster.designpatterns.beveragemaker;

public class CoffeeShop {
    public static void main(String[] args) {
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.prepareBeverage();

        BeverageMaker teaMaker = new TeaMaker();
        teaMaker.prepareBeverage();
    }
}
