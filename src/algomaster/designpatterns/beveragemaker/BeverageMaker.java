package algomaster.designpatterns.beveragemaker;

public abstract class BeverageMaker {
    public final    void prepareBeverage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater(){
        System.out.println("Boiling water...");
    }

    public abstract void brew();

    public void pourInCup(){
        System.out.println("Pouring in cup...");
    }

    public abstract void addCondiments();

}
