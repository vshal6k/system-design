package algomaster.designpatterns.menusystem;

public class MenuItem implements MenuSystemItem{

    private String name;
    private String price;

    public MenuItem(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Item: " + this.name + " Price: " + this.price);
    }
    
}
