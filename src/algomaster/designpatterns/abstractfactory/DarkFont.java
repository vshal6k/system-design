package algomaster.designpatterns.abstractfactory;

public class DarkFont implements ThemeFont {
    @Override
    public void render() {
        System.out.println("Rendering dark theme font: Consolas, 14px");
    }
    
}
