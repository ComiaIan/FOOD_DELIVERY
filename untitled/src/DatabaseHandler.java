import java.sql.*;

public class DatabaseHandler {
    private  static  final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Scholastic1";

    public static Connection connect() throws  SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
