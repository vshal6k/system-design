package algomaster.designpatterns.abstractfactory;

public class LightColor implements ThemeColor {
    @Override
    public void apply() {
        System.out.println("Applying light color: #FFFFFF background, #000000 text");
    }
}
