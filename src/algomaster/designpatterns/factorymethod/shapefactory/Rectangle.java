package algomaster.designpatterns.factorymethod.shapefactory;

import java.math.BigDecimal;

public class Rectangle implements Shape{

    private BigDecimal width = BigDecimal.valueOf(4);
    private BigDecimal height= BigDecimal.valueOf(1);

    @Override
    public BigDecimal area() {
        return width.multiply(height).setScale(2);
    }

    @Override
    public void describe() {
        System.out.println("Rectangle with area " + area());
    }
    
}
