package algomaster.designpatterns.menusystem;

public class Restaurant {

    public static void main(String[] args) {

        MenuItem virginMojito = new MenuItem("Virgin Mojito", "750");
        MenuItem coffee = new MenuItem("Coffee", "450");
        MenuItem beer = new MenuItem("Beer", "1000");

        Menu drinksMenu = new Menu("Drinks Menu");
        drinksMenu.addMenuItem(beer);
        drinksMenu.addMenuItem(coffee);
        drinksMenu.addMenuItem(virginMojito);


        MenuItem paneer = new MenuItem("Paneer", "750");
        MenuItem roti = new MenuItem("Roti", "450");
        MenuItem bread = new MenuItem("Bread", "1000");

        Menu foodMenu = new Menu("Food Menu");
        foodMenu.addMenuItem(paneer);
        foodMenu.addMenuItem(roti);
        foodMenu.addMenuItem(bread);

        MenuItem mouthFreshner = new MenuItem("Pan Vilas", "5");

        Menu fastFoodMenu = new Menu("Fast Food");
        fastFoodMenu.addMenuItem(new MenuItem("Fries", "150"));
        fastFoodMenu.addMenuItem(new MenuItem("Burger", "90"));

        Menu masterMenu = new Menu("Master Menu");

        Menu eatableMenu = new Menu("Eatable Menu");
        eatableMenu.addMenuItem(foodMenu);
        eatableMenu.addMenuItem(fastFoodMenu);

        masterMenu.addMenuItem(eatableMenu);
        masterMenu.addMenuItem(drinksMenu);
        masterMenu.addMenuItem(mouthFreshner);

        System.out.println(masterMenu.getItemCount());
        masterMenu.display("");

    }

}
