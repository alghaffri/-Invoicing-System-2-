import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

	 public static void main(String[] args) throws IOException, InterruptedException {
	        
	        Shop shop = new Shop();
	        // To load the data to the arraylist to be avalible once the program starts
	        //shop.loadItemsFromFile();
	        //shop.loadInvoice();

	        boolean mainMenu = true;
	        Scanner userInput = new Scanner(System.in);
	        System.out.println("Enter user :");
	        String user = userInput.nextLine();
	        System.out.println("Enter Pasword :");
	        String Pasword = userInput.nextLine();
	        if(!user.equalsIgnoreCase("sa") || !Pasword.equalsIgnoreCase("root")) {
	        	System.out.println("Wrong info");
	        	mainMenu = false;
	        }
	        while (mainMenu) {
	            Menu.showMenu(1);;
	            try {

	                System.out.print("Enter your choice: ");
	                int choice = userInput.nextInt();

	                switch (choice) {
	                /*
	                 *  A switch case to handle the navigation between options in the Shop Settings Menu
	                 */
	                case 1:
	                    Menu.showMenu(2);;
	                    System.out.print("Enter your choice: ");
	                    int shopSettingChoice = userInput.nextInt();

	                    switch (shopSettingChoice) {
	                    case 1:
	                    	Item.readFromTable();
	                        break;
	                    case 2:
	                        System.out.print("Enter Shop Name : ");
	                        shop.setShopName(userInput.nextLine());
	                        //shop.createShopTable();
	                        break;
	                    case 3:
	                       
	                        shop.insertDataToShopTable();
	        
	                        break;
	                    case 4:

	                        System.out.println("Going back to the previous menu...");

	                        break;
	                    }

	                    break;
	                    /*
	                     *  A switch case to handlw the navigation between options in the Manage Shop Items Menu
	                     */
	                case 2:
	                    Menu.showMenu(3);;
	                    System.out.print("Enter your choice: ");
	                    int manageShopItemsChoice = userInput.nextInt();

	                    switch (manageShopItemsChoice) {

	                    case 1:
	                        // Add Items and save them to a file
	                       // shop.addItem();
	                        System.out.println("Added the Item Successfully");
	                        break;
	                    case 2:
	                        // Show the Avalible Items and Promote the user to enter
	                        // which Item Id to be deleted
	                      //  shop.printItems();
	                        System.out.println("Enter the ItemID:");
	                        int userChoice =userInput.nextInt();
	                      //  shop.deleteItem(userChoice);
	                        System.out.println("Deleted");
	                        break;
	                    case 3:
	                        // Change Item Price
	                        break;
	                    case 4:
	                        // Report All the Items
	                      //  shop.loadItemsFromFile();
	                      //  shop.printItems();
	                        break;
	                    case 5:
	                        // Go BACK
	                        System.out.println("Going back to the previous menu...");
	                        Menu.showMenu(1);;
	                        break;
	                    }
	                    break;

	                case 3:
	                  
	                    //shop.printItems();
	                    
	                  
	                   Invoice.createInvoiceTable();
	                    System.out.println("Invoice created Successfully");
	                    break;
	                case 4:
	                    // Report: Statistics (No Of Items, No of Invoices, Total Sales)
	                    break;
	                case 5:
	                   Invoice.readFromInvoiceTable();
	                    break;
	                case 6:
	                	Invoice.searchInvoiceById();
	                    break;
	                case 7:      
	                    //program statsitcs
	                    break;
	                case 8:
	                    System.out.print("Are you sure you want to exit? (yes/no): ");
	                    String exitChoice = userInput.next();
	                    if (exitChoice.equals("yes")) {
	                        System.out.println("Exiting the program...");
	                        return;
	                    }
	                    break;
	                }  
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input, please enter a number.");
	                userInput.nextLine(); // clear the input buffer

	            }

	        }
	    }

}