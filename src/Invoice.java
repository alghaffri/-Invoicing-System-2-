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

public class Invoice {

	private String customerName;
	private int phoneNumber;
	private String invoiceDate;
	private int numberItems;
	private int totalAmount;
	private int paidAmoun;
	private int balance;
	Item[] items;

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

	public static void createInvoiceTable() {
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
	        if (!resultSet.next()) {
	            String createTableSql = "CREATE TABLE CUSTOMER_INVOICE (" + "Invoice_ID INT IDENTITY(1,1) PRIMARY KEY,"
	                    + "Invoice_Number INT," + "Customer_Full_Name VARCHAR(255)," + "Phone_Number INT,"
	                    + "Invoice_Date VARCHAR(255)," + "Number_Of_Items INT," + "Total_Amount FLOAT,"
	                    + "Paid_Amount FLOAT," + "Balance FLOAT" + ")";
	            PreparedStatement createTableStatement = connection.prepareStatement(createTableSql);
	            createTableStatement.executeUpdate();
	            System.out.println("Table created successfully");
	        }
	        for (int i = 0; i < numberOfInvoices; i++) {
	            System.out.println("+++++++ Invoice " + (i + 1) + "+++++++++");
	            System.out.println(" enter customer's full name:");
	            String customerName = bufferedReader.readLine();
	            System.out.println(" enter customer's phone number:");
	            int phoneNumber = scanner.nextInt();
	            System.out.println(" enter invoice date:");
	            String invoiceDate = scanner.next();
	            System.out.println(" enter number of items:");
	            int numberOfItems = scanner.nextInt();
	            System.out.println(" enter total amount:");
	            float totalAmount = scanner.nextFloat();
	            System.out.println(" enter paid amount:");
	            float paidAmount = scanner.nextFloat();
	            float balance = paidAmount - totalAmount;
	            String insertSql = "INSERT INTO CUSTOMER_INVOICE(Customer_Full_Name,Phone_Number,Invoice_Date,Number_Of_Items,Total_Amount,Paid_Amount,Balance) VALUES(?,?,?,?,?,?,?)";
	            PreparedStatement ps = connection.prepareStatement(insertSql);
	            ps.setString(1, customerName);
	            ps.setInt(2, phoneNumber);
	            ps.setString(3, invoiceDate);
	            ps.setInt(4, numberOfItems);
	            ps.setFloat(5, totalAmount);
	            ps.setFloat(6, paidAmount);
	            ps.setFloat(7, balance);
	            ps.executeUpdate();
	            System.out.println("Data successfully inserted");
	        }
	    } catch (Exception ex) {
	        System.err.println(ex);
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                System.err.println(e);
	            }
	        }
	    }
	}

	
	

	public static void readFromInvoiceTable() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sql = "SELECT * FROM Invoice";

		java.sql.Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url1 = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
					+ "trustServerCertificate=true";
			String user1 = "sa";
			String pass1 = "root";
			Connection con1 = DriverManager.getConnection(url1);

			PreparedStatement pstmt = con1.prepareStatement(sql);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				System.out.println("+++++++++++++++++++++++++");
				System.out.println("id:" + " " + resultSet.getInt(1));
				System.out.println("customerName:" + " " + resultSet.getString(2));
				System.out.println("phone_Number:" + " " + resultSet.getInt(3));
				System.out.println("invoice_Date:" + " " + resultSet.getDate(4));
				System.out.println(" number_Items:" + " " + resultSet.getInt(5));
				System.out.println(" total_Amount:" + " " + resultSet.getInt(6));
				System.out.println(" paid_Amoun:" + " " + resultSet.getInt(6));
				System.out.println(" balance:" + " " + resultSet.getInt(6));
				System.out.println(" item_Id:" + " " + resultSet.getInt(6));

			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void getByIdInvoice() {

		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner sa = new Scanner(System.in);
		System.out.println(" input ID :");
		int user1 = sa.nextInt();

		String sql = "select * from Invoice inner join items on items.id = invoice.Items_id where invoice.id=" + user
				+ "";

		java.sql.Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url1 = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
					+ "trustServerCertificate=true";
			String user4 = "sa";
			String pass1 = "root";
			Connection con1 = DriverManager.getConnection(url1);

			PreparedStatement pstmt = con1.prepareStatement(sql);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 0;

			while (resultSet.next()) {

				System.out.println("id:" + " " + resultSet.getInt(1));
				System.out.println("customerName:" + " " + resultSet.getString(2));
				System.out.println("phone_Number:" + " " + resultSet.getInt(3));
				System.out.println("invoice_Date:" + " " + resultSet.getDate(4));
				System.out.println(" number_Items:" + " " + resultSet.getInt(5));
				System.out.println(" total_Amount:" + " " + resultSet.getInt(6));
				System.out.println(" paid_Amoun:" + " " + resultSet.getInt(6));
				System.out.println(" balance:" + " " + resultSet.getInt(6));

			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

}