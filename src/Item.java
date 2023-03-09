
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Item {
  
	private int  itemID;
	private String  itemName;
	private String  unitPrice;
	private int quantity;
	private int qtyAmount;
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQtyAmount() {
		return qtyAmount;
	}
	public void setQtyAmount(int qtyAmount) {
		this.qtyAmount = qtyAmount;
	}
	
	
	
	
	
	public static void createItemsTable() {
		 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
		            + "trustServerCertificate=true";
		String username = "sa";
		String password = "root";
		Scanner scanner = new Scanner(System.in);
		try {
		Connection connection = null;
		Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		String createTableSql = "CREATE TABLE Item (" +
		"id INT PRIMARY KEY, " +
		"name VARCHAR(50) NOT NULL, " +
		"price FLOAT NOT NULL, " +
		"quantity INT NOT NULL)";
		statement.executeUpdate(createTableSql);
		System.out.println("Table created successfully");
		int numberOfItems = 0;
		while (numberOfItems <= 0) {
		System.out.println("Enter the number of items to add:");
		numberOfItems = scanner.nextInt();
		}
		for (int i = 0; i < numberOfItems; i++) {
		System.out.println("++++++++ Item " + (i + 1) + " ++++++++");
		System.out.println("Enter item ID:");
		int id = scanner.nextInt();
		scanner.nextLine(); // consume the remaining newline character
		System.out.println("Enter item name:");
		String name = scanner.nextLine();
		System.out.println("Enter item price:");
		float price = scanner.nextFloat();
		System.out.println("Enter item quantity:");
		int quantity = scanner.nextInt();
		String insertSql = "INSERT INTO Item(id, name, price, quantity) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(insertSql);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setFloat(3, price);
		ps.setInt(4, quantity);
		ps.executeUpdate();
		System.out.println("Data successfully inserted");
		}
		} catch (Exception ex) {
		System.err.println(ex);
		}
		
		}
		
		
	
	
	public static void deleteByItems()  {
		 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
		            + "trustServerCertificate=true";
		String username = "sa";
		String password = "root";
		Scanner scanner = new Scanner(System.in);
		try {
		Connection connection = null;
		Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
			
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Please Enter id you want to delete :");
			String userinput = scanner.next();
			String sql = "delete from Items where id ='" + userinput + "'";
		
			
		} catch (Exception excep) {
			System.err.println(excep);
		
		}

	}
	
	public static void updateByItems() {
		 String url = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
		Connection conn = null;
		
		java.sql.Connection conn1 = null;
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    String url1 = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user2 = "sa";
	        String pass3 = "root";
		    Connection con1 = DriverManager.getConnection(url1);
		    
		    PreparedStatement pstmt = con1.prepareStatement(url1);
			java.sql.Statement stmt =  conn1.createStatement();
			
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter any id you want to update:");
			int user_input = scanner.nextInt();
			
			System.out.println("Please Enter the new qtyAmount:");
			int qty_Amount = scanner.nextInt();
			
			

		
			String sql = "UPDATE Items SET qtyAmount=" + qty_Amount+ " where id="+user_input+"";
			int result =  stmt.executeUpdate(sql);
			
			} catch (Exception excep) {
				System.err.println(excep);
			
			}

		}

	
	
	public static void readFromTable() {
		 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
		            + "trustServerCertificate=true";
		    String username = "sa";
		    String password = "root";
		    Scanner scanner = new Scanner(System.in);
		   
		    int numberOfInvoices = scanner.nextInt();
		    Connection connection = null;
		    try {
		        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		        DriverManager.registerDriver(driver);
		        connection = DriverManager.getConnection(url, username, password);
		        DatabaseMetaData metadata = connection.getMetaData();
		        ResultSet resultSet = metadata.getTables(null, null, "TABLE", null);
			int count = 1;
			while (resultSet.next()) {
				System.out.println("##########################");
				System.out.println ("id:"+" "+resultSet.getInt(1));
				System.out.println ("itemID:"+" " + resultSet.getInt(2));
				System.out.println ("itemName:"+" " + resultSet.getString(3));
				System.out.println ("unitPrice:"+ " " + resultSet.getString(4));
				System.out.println(" quantity:"+" " + resultSet.getInt(5));
				System.out.println(" qtyAmount:"+" " +  resultSet.getInt(6));
				System.out.println("##########################");

			}

			
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
	
	
	
	
	
}

	