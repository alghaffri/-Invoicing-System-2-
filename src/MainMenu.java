import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class MainMenu {
    private static final String CREATE_PRODUCT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS products ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,"
            + "price REAL NOT NULL"
            + ")";
    private static final String CREATE_INVOICE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS invoices ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "customer_name TEXT NOT NULL,"
            + "total REAL NOT NULL,"
            + "balance REAL NOT NULL"
            + ")";
    private static final String CREATE_INVOICE_ITEM_TABLE_SQL = "CREATE TABLE IF NOT EXISTS invoice_items ("
            + "invoice_id INTEGER NOT NULL,"
            + "product_id INTEGER NOT NULL,"
            + "quantity INTEGER NOT NULL,"
            + "FOREIGN KEY (invoice_id) REFERENCES invoices (id),"
            + "FOREIGN KEY (product_id) REFERENCES products (id)"
            + ")";

    public static void initializeDatabase(String url, String username, String password) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            java.sql.Statement stmt = conn.createStatement();
            stmt.execute(CREATE_PRODUCT_TABLE_SQL);
            stmt.execute(CREATE_INVOICE_TABLE_SQL);
            stmt.execute(CREATE_INVOICE_ITEM_TABLE_SQL);
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    	  String url = "jdbc:sqlserver://localhost:1433;" +
                  "databaseName=InvoicingSystem;" +
                  "encrypt=true;" +
                  "trustServerCertificate=true";
          String user = "sa";
          String pass = "root";
        initializeDatabase(url, user, pass);
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        boolean exit = false;

        while (!exit) {
            menu.showMenu();
            System.out.print("Select an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Shop Settings");
                    // TODO: Handle Shop Settings menu options
                    break;
                case 2:
                    System.out.println("Manage Shop Items");
                    // TODO: Handle Manage Shop Items menu options
                    break;
                case 3:
                    System.out.println("Create New Invoice");
                    // TODO: Handle Create New Invoice menu options
                    break;
                case 4:
                    System.out.println("Report: Statistics");
                    // TODO: Handle Report Statistics menu options
                    break;
                case 5:
                    System.out.println("Report: All Invoices");
                    // TODO: Handle Report All Invoices menu options
                    break;
                case 6:
                    System.out.println("Search Invoice");
                    // TODO: Handle Search Invoice menu options
                    break;
                case 7:
                    System.out.println("Program Statistics");
                    // TODO: Handle Program Statistics menu options
                    break;
                case 8:
                    System.out.print("Are you sure you want to exit? (y/n): ");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("y")) {
                        System.out.println("Exiting program...");
                        exit = true;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        input.close();
    }
}
