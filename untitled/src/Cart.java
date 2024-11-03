import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items = new HashMap<>();

    public void addItem(FoodItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
        System.out.println("Added " + quantity + " of " + item.getName() + " to cart.");
    }

    public void removeItem(FoodItem item) {
        if (items.containsKey(item)) {
            items.remove(item);
            System.out.println("Removed " + item.getName() + " from cart.");
        } else {
            System.out.println("Item not in cart.");
        }
    }

    public void updateItemQuantity(FoodItem item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, quantity);
            System.out.println("Updated quantity of " + item.getName() + " to " + quantity + " in cart.");
        } else {
            System.out.println("Item not in cart.");
        }
    }

    public void viewCart() {
        System.out.println("Your Cart:");
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(item.getName() + " - Quantity: " + quantity + " - Price: $" + (item.getPrice() * quantity));
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared.");
    }
}
