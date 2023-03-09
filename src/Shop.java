import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Shop {
	private String  shopName;
	private int telephone;
	private String Fax;
	private String  email; 
	   

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    Scanner scanner = new Scanner(System.in);

	 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
	            + "trustServerCertificate=true";
	    String username = "sa";
	    String password = "root";

	public void createShopTable() {
		 try {
		 Connection connection = null;
		 // Load SQL Server JDBC driver
		 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		 DriverManager.registerDriver(driver);
		 // Establish database connection
		 connection = DriverManager.getConnection(url, username, password);
		 Statement statement = connection.createStatement();
		 // Create a table named "shop"
		 String createTableQuery = "CREATE TABLE shop (" 
		      + "name varchar(50) ," 
		      + "telephone VARCHAR(255) NOT NULL,"
		      + "email varchar(50) NOT NULL,"   
		      + ")";
		 // Close the database connection
		 connection.close();
		 } catch (Exception exception) {
		 System.err.println(exception);
		 }
		}


	
	public void insertDataToShopTable() {
		 try {
		 Connection connection = null;
		 // Load SQL Server JDBC driver
		 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		 DriverManager.registerDriver(driver);
		 // Establish database connection
		 connection = DriverManager.getConnection(url, username, password);
		 Statement statement = connection.createStatement();
		 // Create a new shop object and set its properties based on user input
		 Shop shop = new Shop();
		 System.out.println("Enter shop name: ");
		 String shopName = scanner.nextLine();
		 shop.setShopName(shopName);
		 System.out.println("Enter telephone number: ");
		 int telephone = scanner.nextInt();
		 shop.setTelephone(telephone);
		// System.out.println("Enter fax number: ");
		// String fax = scanner.nextLine();
		// shop.setFax(fax);
		 System.out.println("Enter email address: ");
		 String email = scanner.next();
		 shop.setEmail(email);
	
		 // Construct SQL query to insert the shop data into the shop table
		 String insertQuery = "INSERT INTO shop (name, telephone, email) VALUES ('" 
		      + shopName + "', '" + telephone + "', '" + email + "')";
		 // Execute the query to insert the data
		 int rowsAffected = statement.executeUpdate(insertQuery);
		 if (rowsAffected >= 1) {
		 System.out.println("Data inserted successfully: ");
		 } else {
		 System.out.println("Data insertion failed");
		 }
		 // Close the database connection
		 connection.close();
		 } catch (Exception exception) {
		 System.err.println(exception);
		 }
		}
}