package algomaster.designpatterns.factorymethod.shapefactory;

public class CircleFactory implements ShapeFactory{

    @Override
    public Shape createShape() {
        return new Circle();
    }
    
}
