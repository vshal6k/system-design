package algomaster.designpatterns.abstractfactory;

public class DarkColor implements ThemeColor {
    @Override
    public void apply() {
        System.out.println("Applying dark color: #000000 background, #FFFFFF text");
    }
    
}
