import java.beans.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	
	
	
	
	public static void createItemsTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
		            + "trustServerCertificate=true";
		    String username = "sa";
		    String password = "root";
		    Scanner scanner = new Scanner(System.in);
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Enter the number of invoices to create:");
		    int numberOfInvoices = scanner.nextInt();
		    Connection connection = null;
		    try {
		        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		        DriverManager.registerDriver(driver);
		        connection = DriverManager.getConnection(url, username, password);
		        DatabaseMetaData metadata = connection.getMetaData();
		        ResultSet resultSet = metadata.getTables(null, null, "CUSTOMER_INVOICE", null);
	            String sql = "CREATE TABLE Item (" +
	                            "id INT PRIMARY KEY, " +
	                            "name VARCHAR(50) NOT NULL, " +
	                            "age INT NOT NULL)";
	           
	            System.out.println("Table created successfully!");
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        
	        }

	    }
	
	
	public static void insertIntoItemsTable()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Scanner sa = new Scanner(System.in);
		
		System.out.println("PLS Enter item Name");
		String item_Name = sa.next();
		
		System.out.println("PLS Enter unit Price");
		String unitPrice = sa.next();
		
		System.out.println("PLS Enter quantity");
		int quantity = sa.nextInt();
		
		System.out.println("PLS Enter qtyAmount");
		int qtyAmount = sa.nextInt();
		
		System.out.println("PLS Enter shop name you want");
		String name = sa.next();
		
		String sql = "select id  from Shop where ShopName ='" + name + "'";
		Connection con = null;
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    String url1 = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user1 = "sa";
	        String pass1 = "root";
		    Connection con1 = DriverManager.getConnection(url1);
		    
		    PreparedStatement pstmt = con1.prepareStatement(sql);
			try {
				int shop_id = 0;
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					shop_id = rs.getInt("id");
				}
				sql = "INSERT INTO Items(itemId,itemName,unitPrice,quantity,qtyAmount,Shop_id)VALUES";
				try {
					PreparedStatement pstmt3 = con.prepareStatement(sql);
					pstmt3.setString(2, item_Name);
					pstmt3.setString(3, unitPrice);
					pstmt3.setInt(4, quantity);
					pstmt3.setInt(5, qtyAmount);
					pstmt3.setInt(6, shop_id);
					pstmt3.executeUpdate();
					System.out.println("added successfully");
					Statement st = (Statement) con.createStatement();
					int m = ((java.sql.Statement) st).executeUpdate(sql);
					if (m >= 1) {
						System.out.println("Inserte table in database is success...");
					} else {
						System.out.println(" table already Inserte in given database...");
					}
					con.close();
				} catch (Exception e) {
				    e.printStackTrace();
				}			} catch (SQLException e) {
				System.out.println(e);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
	public static void deleteByItems()  {
		 String url = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
		Connection con = null;
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
			java.sql.Statement st =con.createStatement();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter id you want to delete :");
			String userinput = scanner.next();
			String sql = "delete from Items where id ='" + userinput + "'";
			int result = ((java.sql.Statement) st).executeUpdate(sql);
			
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
		 String url = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
		String sql = "SELECT * FROM Items";
		

		java.sql.Connection conn = null;
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
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
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

			conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
	
	
	
	
	
}

	