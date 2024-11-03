public class Customer extends User {
    public Customer(int userId, String username, String password) {
        super(userId, username, password);
    }

    @Override
    public void viewMenu() {
        System.out.println("Lalagyan ko pa ng logic...");
    }
}
