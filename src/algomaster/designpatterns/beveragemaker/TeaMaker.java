package algomaster.designpatterns.beveragemaker;

public class TeaMaker extends BeverageMaker{

    @Override
    public void brew() {
        System.out.println("Brewing tea bag...");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon...");
    }
    
}
