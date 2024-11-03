import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admin extends User{
    public Admin (int userId, String username, String password) {
        super(userId, username, password);
    }

    @Override
    public void viewMenu() {

    }

    public void addRestaurant(String name, String location, Connection conn) throws SQLException {
        String sql = "INSERT INTO Restaurants (name, location) VALUES (?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,name);
            stmt.setString(2, location);
            stmt.executeUpdate();
            System.out.println("Restaurant added successfully!");
        }
    }

    public void addFoodItem(String name, double price, int restaurantId, Connection conn) throws SQLException {
        String sql = "INSERT INTO FoodItems (name, price, restaurant_id) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, restaurantId);
            stmt.executeUpdate();
            System.out.println("Food item added successfully!");
        }
    }
}
