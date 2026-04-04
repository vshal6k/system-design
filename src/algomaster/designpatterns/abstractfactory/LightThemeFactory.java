package algomaster.designpatterns.abstractfactory;

public class LightThemeFactory implements ThemeFactory {
    @Override
    public ThemeColor createColor() {
        return new LightColor();
    }

    @Override
    public ThemeFont createFont() {
        return new LightFont();
    }
    
}
