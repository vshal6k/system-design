package algomaster.designpatterns.prototype;

import java.math.BigDecimal;

public class Circle implements Prototype {
    private BigDecimal radius;
    private String color;

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(BigDecimal radius, String color){
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Prototype clone(){
        return new Circle(radius, color);
    }
}
