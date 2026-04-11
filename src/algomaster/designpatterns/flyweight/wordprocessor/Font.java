package algomaster.designpatterns.flyweight.wordprocessor;

public class Font {
    private FontStyle fontStyle;

    public Font(FontStyle fontStyle){
        this.fontStyle = fontStyle;
    }

    public void render(int line, int column, char caharacter){
        this.fontStyle.format(line, column, caharacter);
    }
}
