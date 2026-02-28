package algomaster.abstraction;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(String name, double height, double width){
        super(name);
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public double perimeter() {
        return 2*height*width;
    }
    
}
