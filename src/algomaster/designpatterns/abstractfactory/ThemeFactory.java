package algomaster.designpatterns.abstractfactory;

public interface ThemeFactory {
    public ThemeColor createColor();
    public ThemeFont createFont();
}
