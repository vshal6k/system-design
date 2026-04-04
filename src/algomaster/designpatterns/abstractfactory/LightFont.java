package algomaster.designpatterns.abstractfactory;

public class LightFont implements ThemeFont {
    @Override
    public void render() {
        System.out.println("Rendering light theme font: Arial, 12px");
    }
    
}
