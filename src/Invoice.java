import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Invoice {

	private String customerName;
	private int phoneNumber;
	private String invoiceDate;
	private int numberItems;
	private int totalAmount;
	private int paidAmoun ;
	private int balance ;
	Item [] items;
	
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public int getNumberItems() {
		return numberItems;
	}
	public void setNumberItems(int numberItems) {
		this.numberItems = numberItems;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getPaidAmoun() {
		return paidAmoun;
	}
	public void setPaidAmoun(int paidAmoun) {
		this.paidAmoun = paidAmoun;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public static boolean createInvoiceTable() {
	 String url = "jdbc:sqlserver://localhost:1433;" +
             "databaseName=Invoice;" +
             "encrypt=true;" +
             "trustServerCertificate=true";
     String user = "sa";
     String pass = "root";
	try (Connection connection = DriverManager.getConnection(url, user, pass);
			 java.sql.Statement statement = connection.createStatement()) {
		String sqlDB = "CREATE TABLE Invoice (\"\r\n"
				+ "                    + \"id INT NOT NULL AUTO_INCREMENT,\"\r\n"
				+ "                    + \"invoice_date DATE NOT NULL,\"\r\n"
				+ "                    + \"customer_name VARCHAR(50) NOT NULL,\"\r\n"
				+ "                    + \"total_price DECIMAL(10, 2) NOT NULL,\"\r\n"
				+ "                    + \"items_id INT NOT NULL,\"\r\n"
				+ "                    + \"PRIMARY KEY (id),\"\r\n"
				+ "                    + \"FOREIGN KEY (items_id) REFERENCES Items(id)\"\r\n"
				+ "                    + \")\";";
		statement.executeUpdate(sqlDB);
		System.out.println("Tables created successfully.");
	} catch (SQLException e) {
		System.out.println("Error creating tables: " + e.getMessage());
	}
	return false;
}
	
	public static void insertIntoInvoiceTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {


		Scanner sc = new Scanner(System.in);
		System.out.println("PLS Enter Database URL");
		String url = sc.next();
		
		System.out.println("PLS Enter userName");
		String user = sc.next();
		
		System.out.println("PLS Enter password");
		String pass = sc.next();
	
		System.out.println(" itemName :");
		String item_Name=sc.next();	
		
		
		System.out.println(" customerName :");
		String customer_Name=sc.next();	
		
	
		System.out.println(" phoneNumber :");
		int phone_Number=sc.nextInt();
		
	
		System.out.println(" invoiceDate :");
		String invoice_Date=sc.next();
		
		
		

		System.out.println(" numberItems :");
		int number_Items=sc.nextInt();
		
		

		System.out.println(" totalAmount :");
		int total_Amount=sc.nextInt();
		
		

		System.out.println(" paidAmount :");
		int paid_Amoun=sc.nextInt();
		
	
		System.out.println(" balance :");
		int balance=sc.nextInt();
		
		System.out.println(" item Id :");
		int item_Id=sc.nextInt();
		
		String sql = "select id  from Items where itemName ='" +item_Name  + "'";
		Connection con = null;
		
		
		
		
		try (Connection connection = DriverManager.getConnection(url, user, pass);
				 java.sql.Statement statement = connection.createStatement()) {
			System.out.println("Tables created successfully.");
		} catch (SQLException e) {
			System.out.println("Error creating tables: " + e.getMessage());	}
			
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);
		
			try {
				int shop_id = 1;
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					shop_id = rs.getInt("id");
				}
				sql = "INSERT INTO Invoice(customerName,phoneNumber,invoiceDate,numberItems,totalAmount,paidAmoun,balance,Items_id)VALUES(?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement stat = con.prepareStatement(sql);
				//	pstmt3.setString(1, item_Name);
					stat.setString(1, customer_Name);
					stat.setInt(2, phone_Number);
					stat.setString(3, invoice_Date);
					stat.setInt(4, number_Items);
					stat.setInt(5, total_Amount);
					stat.setInt(6, paid_Amoun);
					stat.setInt(7, balance);
					stat.setInt(8, item_Id);
					stat.executeUpdate();
					System.out.println("added successfully");
					con = DriverManager.getConnection(url, user, pass);
					Statement st = (Statement) con.createStatement();
					int m = ((java.sql.Statement) st).executeUpdate(sql);
					if (m >= 1) {
						System.out.println("Inserte table in database is success...");
					} else {
						System.out.println(" table already Inserte in given database...");
					}
					con.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	
	
	public static void readFromInvoiceTable() {
		 String url = "jdbc:sqlserver://localhost:1433;" +
	             "databaseName=Invoice;" +
	             "encrypt=true;" +
	             "trustServerCertificate=true";
	     String user = "sa";
	     String pass = "root";
		String sql = "SELECT * FROM Invoice";
		

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
		    
		    PreparedStatement pstmt = con1.prepareStatement(sql);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				System.out.println("+++++++++++++++++++++++++");
				System.out.println ("id:"+" "+resultSet.getInt(1));
				System.out.println ("customerName:"+" " + resultSet.getString(2));
				System.out.println ("phone_Number:"+" " + resultSet.getInt(3));
				System.out.println ("invoice_Date:"+ " " + resultSet.getDate(4));
				System.out.println(" number_Items:"+" " + resultSet.getInt(5));
				System.out.println(" total_Amount:"+" " +  resultSet.getInt(6));
				System.out.println(" paid_Amoun:"+" " +  resultSet.getInt(6));
				System.out.println(" balance:"+" " +  resultSet.getInt(6));
				System.out.println(" item_Id:"+" " +  resultSet.getInt(6));

	

			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	
	public static void getByIdInvoice() {

		 String url = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
		Scanner sa = new Scanner(System.in);
		System.out.println(" input ID :");
		int user1 = sa.nextInt();

		String sql = "select * from Invoice inner join items on items.id = invoice.Items_id where invoice.id=" + user+"";

		java.sql.Connection conn = null;
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    String url1 = "jdbc:sqlserver://localhost:1433;" +
	                "databaseName=Invoice;" +
	                "encrypt=true;" +
	                "trustServerCertificate=true";
	        String user4 = "sa";
	        String pass1 = "root";
		    Connection con1 = DriverManager.getConnection(url1);
		    
		    PreparedStatement pstmt = con1.prepareStatement(sql);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 0;
			
			while (resultSet.next()) {
			
	
			System.out.println ("id:"+" "+resultSet.getInt(1));
			System.out.println ("customerName:"+" " + resultSet.getString(2));
			System.out.println ("phone_Number:"+" " + resultSet.getInt(3));
			System.out.println ("invoice_Date:"+ " " + resultSet.getDate(4));
			System.out.println(" number_Items:"+" " + resultSet.getInt(5));
			System.out.println(" total_Amount:"+" " +  resultSet.getInt(6));
			System.out.println(" paid_Amoun:"+" " +  resultSet.getInt(6));
			System.out.println(" balance:"+" " +  resultSet.getInt(6));
		

		

			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	}