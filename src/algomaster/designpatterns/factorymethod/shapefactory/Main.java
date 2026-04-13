package algomaster.designpatterns.factorymethod.shapefactory;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new CircleFactory();
        Shape shape = shapeFactory.createShape();
        shape.describe();
    }
}
