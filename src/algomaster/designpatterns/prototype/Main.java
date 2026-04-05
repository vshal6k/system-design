package algomaster.designpatterns.prototype;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PrototypeRegistry prototypeRegistry = new PrototypeRegistry();
        Rectangle baseRectangle = new Rectangle(BigDecimal.valueOf(1), BigDecimal.valueOf(1), "Black");
        Circle baseCircle = new Circle(BigDecimal.valueOf(1), "Black");

        prototypeRegistry.registerPrototype("baseCircle", baseCircle);
        prototypeRegistry.registerPrototype("baseRectanglr", baseRectangle);

        Prototype baseCircleCopy = prototypeRegistry.getPrototypeInstance("baseCircle");
        Circle redBaseCircle = (Circle)baseCircleCopy;
        redBaseCircle.setColor("Red");

        System.out.println(baseCircle.getColor());
        System.out.println(redBaseCircle.getColor());

    }
}
