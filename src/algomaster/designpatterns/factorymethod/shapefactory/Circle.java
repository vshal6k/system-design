package algomaster.designpatterns.factorymethod.shapefactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements Shape {
    private BigDecimal radius = BigDecimal.valueOf(2);

    @Override
    public BigDecimal area() {
        return BigDecimal.valueOf(Math.PI).multiply(radius).multiply(radius).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void describe() {
        System.out.println("Circle with area " + area().toString());
    }

}
