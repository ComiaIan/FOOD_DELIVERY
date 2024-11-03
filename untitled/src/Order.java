import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void placeOrder(Connection conn) throws SQLException {
        String sql = "INSERT INTO Orders (user_id, restaurant_id, item_id, quantity, status) VALUES (?, ?, ?, ?, 'Pending')";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, restaurantId);
            stmt.setInt(3, itemId);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
            System.out.println("Order placed successfully!");
        }
    }

    public void trackOrder(int orderId, Connection conn) throws SQLException {
        String sql = "SELECT status FROM Orders WHERE order_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Order Status: " + rs.getString("status"));
            } else {
                System.out.println("Order not found.");
            }
        }
    }
}
