package algomaster.designpatterns.factorymethod.shapefactory;

public class RectangleFactory implements ShapeFactory{

    @Override
    public Shape createShape() {
        return new Rectangle();
    }
    
}
