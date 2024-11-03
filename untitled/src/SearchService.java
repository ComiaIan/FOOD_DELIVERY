import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchService {
    public static void searchRestaurant(String restaurantName, Connection conn) throws SQLException {
        String sql = "SELECT * FROM Restaurants WHERE name LIKE ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + restaurantName + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                int restaurantId = rs.getInt("restaurant_id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                System.out.println("Restaurant: " + name + " (Location: " + location + ")");
                displayFoodItems(restaurantId, conn);
            }
        }
    }

    public static void searchFoodItem(String foodName, Connection conn) throws SQLException {
        String sql = "SELECT * FROM FoodItems WHERE name LIKE ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + foodName + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                System.out.println("Food item: " + name + " - Price: $" + price);
            }
        }
    }

    public static void displayFoodItems(int restaurantId, Connection conn) throws SQLException{
        String sql = "SELECT * FROM FoodItems WHERE restaurant_id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, restaurantId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Available Food Items: ");
            while(rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                System.out.println(name + " - $" + price);
            }
        }

    }
}
