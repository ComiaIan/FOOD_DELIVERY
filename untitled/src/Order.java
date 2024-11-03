public class Order {
    private int orderId;
    private int userId;
    private int restaurantId;
    private int itemId;
    private int quantity;
    private String status;

    public Order (int orderId, int userId, int restaurantId, int itemId, int quantity, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.status = status;
    }

    public void placeOrder() {
        System.out.println("Placing order for item ID: " + itemId + ", Quantity: " + quantity);
    }

    public void trackOrder() {
        System.out.println("Tracking order ID: " + orderId + " - Status: " + status);
    }
}
