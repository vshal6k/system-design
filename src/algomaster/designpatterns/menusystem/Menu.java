package algomaster.designpatterns.menusystem;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuSystemItem{

    private String name;
    private List<MenuSystemItem> menuSystemItems = new ArrayList<>();

    public Menu(String name){
        this.name = name;
    }

    public void addMenuItem(MenuSystemItem menuSystemItem){
        this.menuSystemItems.add(menuSystemItem);
    }

    public void removeMenuItem(MenuSystemItem menuSystemItem){
        this.menuSystemItems.remove(menuSystemItem);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getItemCount() {
        int itemCount = 0;
        for (MenuSystemItem menuSystemItem : menuSystemItems) {
            itemCount += menuSystemItem.getItemCount();
        }
        return itemCount;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Menu: " + this.name);
        for (MenuSystemItem menuItem : menuSystemItems) {
            menuItem.display(indent + " ");
        }
    }
    
}
