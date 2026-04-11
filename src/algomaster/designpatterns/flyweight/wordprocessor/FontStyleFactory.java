package algomaster.designpatterns.flyweight.wordprocessor;

import java.util.HashMap;
import java.util.Map;

public class FontStyleFactory {
    private Map<String, FontStyle> fontStyles = new HashMap<>();

    public FontStyle getFontStyle(String fontFamily, int fontSize, boolean isBold, boolean isItalic){
        String key = fontFamily + fontSize + isBold + isItalic;
        fontStyles.putIfAbsent(key, new ConcreteFontStyle(fontFamily, fontSize, isBold, isItalic));
        return fontStyles.get(key);
    }

    public int getStyleCount(){
        return fontStyles.size();
    }
    
}
