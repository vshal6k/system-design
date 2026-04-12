package algomaster.designpatterns.visitor.documentelementvisitor;

public class Image implements DocumentElement{
    private String url;
    private String altText;
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getAltText() {
        return altText;
    }
    public void setAltText(String altText) {
        this.altText = altText;
    }
    public Image(String url, String altText) {
        this.url = url;
        this.altText = altText;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }
    
}
