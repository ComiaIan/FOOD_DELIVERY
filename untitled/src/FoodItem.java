public class FoodItem {
    private final int id;
    private final String name;
    private final double price;
    private final int restaurantId;

    public FoodItem(int id, String name, double price, int restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public double getPrice() {return price;}
    public int getRestaurantId(){return restaurantId;}

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
