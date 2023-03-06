import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

	public static boolean createShopTable() {
		
		 String url = "jdbc:sqlserver://localhost:1433;" +
	             "databaseName=Invoice;" +
	             "encrypt=true;" +
	             "trustServerCertificate=true";
	     String user = "sa";
	     String pass = "root";
		try (Connection connection = DriverManager.getConnection(url, user, pass);
				 java.sql.Statement statement = connection.createStatement()) {
			  String Table = "CREATE TABLE Shop "+"(id INTEGER NOT NULL, "+" shopName VARCHAR(80), "+" telephone INTEGER,"+" Fax VARCHAR(80), "+" email VARCHAR(80),  "+" PRIMARY KEY ( id ))";
			statement.executeUpdate(Table);
			System.out.println("Tables created successfully.");
		} catch (SQLException e) {
			System.out.println("Error creating tables: " + e.getMessage());
		}
		return false;
	}

	
	public static void insertIntoShopTable() {


		Scanner sa = new Scanner(System.in);

		
		System.out.println(" Enter shop Name ");
		String shop_Name = sa.next();
	
		System.out.println(" Enter telephone");
		int telephone = sa.nextInt();
		
		System.out.println(" Enter Fax ");
		String Fax = sa.next();
		
		System.out.println(" Enter email ");
		String email = sa.next();
		 String url = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";

			String InsertShop = "INSERT INTO  Shop(shopName,telephone,Fax,email )"+" VALUES ('" + shop_Name+ "'," +telephone +",'"+Fax+"','"+email +"' )";			
			java.sql.Connection conn = null;
			try {
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    String url1 = "jdbc:sqlserver://localhost:1433;" +
		                "databaseName=Invoice;" +
		                "encrypt=true;" +
		                "trustServerCertificate=true";
		        String user1 = "sa";
		        String pass1 = "root";
			    Connection con1 = DriverManager.getConnection(url1);
			    
			    PreparedStatement pstmt = con1.prepareStatement(InsertShop);
				java.sql.Statement st = conn.createStatement();
				int m = st.executeUpdate(InsertShop);
				if (m >= 1) {
					System.out.println("inserted data successfuly...");

				} else {
					System.out.println(" faild inserted data...");
				}
				conn.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}

		}
	}
