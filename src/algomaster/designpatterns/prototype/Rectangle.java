package algomaster.designpatterns.prototype;

import java.math.BigDecimal;

public class Rectangle implements Prototype {
    private BigDecimal width;
    private BigDecimal height;
    private String color;

    public Rectangle(BigDecimal width, BigDecimal height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public Prototype clone() {
        return new Rectangle(width, height, color);
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
