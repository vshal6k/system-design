package algomaster.designpatterns.flyweight.wordprocessor;

public class ConcreteFontStyle implements FontStyle{

    private final String fontFamily;
    private final int fontSize;
    private final boolean isBold;
    private final boolean isItalic;


    public ConcreteFontStyle(String fontFamily, int fontSize, boolean isBold, boolean isItalic) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }

    @Override
    public void format(int line, int column, char character) {
        System.out.println("[fontFamily=" + fontFamily + ", fontSize=" + fontSize + ", isBold=" + isBold + ", isItalic=" + isItalic + ", line=" + line  + ", column=" + column + ", character=" + character +"]");
    }
    
}
