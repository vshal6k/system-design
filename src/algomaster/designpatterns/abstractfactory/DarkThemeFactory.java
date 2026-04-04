package algomaster.designpatterns.abstractfactory;

public class DarkThemeFactory implements ThemeFactory {
    @Override
    public ThemeColor createColor() {
        return new DarkColor();
    }

    @Override
    public ThemeFont createFont() {
        return new DarkFont();
    }
    
}
