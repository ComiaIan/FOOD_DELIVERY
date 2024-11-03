import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String location;
    private List<FoodItem> menu;

    public Restaurant(int id, String name, String location, List<FoodItem> menu) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.menu = menu;
    }

    public void displayMenu() {
        System.out.println("Menu for " + name + ": ");
        for(FoodItem item : menu) {
            System.out.println(item);
        }
    }
}
