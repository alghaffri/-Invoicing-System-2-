import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class MainMenu {
	 
	    public static void main(String[] args) {
	    	try {
	    		 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=SystemInvoice;" + "encrypt=true;"
	    		 + "trustServerCertificate=true";
	    		 String user = "sa";
	    		 String password = "root";
	    		 Connection conn = DriverManager.getConnection(url, user, password);
	    		 System.out.println("Connection has been established.");
	    		 } catch (SQLException e) {
	    		 System.out.println(e.getMessage());
	    		 }

		Scanner input = new Scanner(System.in);
		Menu menu = new Menu();
		boolean exit = false;
		int userInput;
		while (!exit) {
			menu.showMenu();
			System.out.print("Select an option: ");
			int choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Shop Settings");
				// TODO: Handle Shop Settings menu option
				  while (true) {
				        System.out.println("Shop Settings Menu");
				        System.out.println("1. Load Data (Items and invoices)");
				        System.out.println("2. Set Shop Name");
				        System.out.println("3. Set Invoice Header (Tel / Fax / Email / Website)");
				        System.out.println("4. Go Back");
				        System.out.print("Enter your choice: ");
				        
				        userInput = input.nextInt();
				        input.nextLine(); // consume newline character

				        if(userInput == 1) {
				            
				                // load data implementation
				        }
				        else 
				        	if(userInput == 2) {
				                System.out.print("Enter shop name: ");
				                String shopName = input.nextLine();
				                // set shop name implementation
				        }
				        else 
						      if(userInput == 3) {
				                System.out.println("Enter invoice header information:");
				                System.out.print("Tel: ");
				                String tel = input.nextLine();
				                System.out.print("Fax: ");
				                String fax = input.nextLine();
				                System.out.print("Email: ");
				                String email = input.nextLine();
				                System.out.print("Website: ");
				                String website = input.nextLine();
						      }
				                // set invoice header implementation
						        	
						      
						      else if(userInput == 4){
				               exit = false;
						      }
						      else {
						    	  System.out.println("Invalid choice, please try again.");
						      }
				  }
		
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
				Shop Shop=new Shop();
				Shop.insertIntoShopTable();
				
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
		
	}
}
