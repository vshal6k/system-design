package algomaster.abstraction;

public abstract class Shape {

    private String name;

    public Shape(String name){
        this.name = name;
    }

    public abstract double area();
    public abstract double perimeter();

    public void describe(){
        // System.out.println("Shape: " + this.name + " Area: " + this.area() + " Perimeter " + this.perimeter());
        System.out.printf("Shape: %s Area: %.2f Perimeter %.2f\n", this.name, this.area(), this.perimeter());
    }

}
