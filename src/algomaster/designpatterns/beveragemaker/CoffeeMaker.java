package algomaster.designpatterns.beveragemaker;

public class CoffeeMaker extends BeverageMaker{

    @Override
    public void brew() {
        System.out.println("Brewing coffee grounds...");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding sugar...");
    }
    
}
