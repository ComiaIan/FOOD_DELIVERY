import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApplication {
    private static DatabaseHandler dbHandler = new DatabaseHandler();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = dbHandler.connect()) {
            System.out.println("Welcome to Food Delivery System!");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> signUp(scanner, conn);
                case 2 -> logIn(scanner, conn);
                default -> System.out.println("Invalid option.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void signUp(Scanner scanner, Connection conn) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Insert user into database and assign customer role
        System.out.println("Sign up successful.");
    }

    private static void logIn(Scanner scanner, Connection conn) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check login credentials
        System.out.println("Log in successful.");
    }
}
