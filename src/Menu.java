import java.util.Arrays;
import java.util.List;

public class Menu {

	public static void showMenu(int option) {

		List<String> MainMenu = Arrays.asList("1.Shop Settings", "2.Manage Shop Items", "3.Create New Invoice",
				"4.Report: Statistics", "5.Report: All Invoices", "6.Search (1) Invoice", "7.Program Statistics",
				"8.Exit");

		List<String> shopMenu = Arrays.asList(  "1.Load Data Items ",
				"2.Set Shop Name", "3.Set Invoice Header (Tel / Fax / Email )", "4.Go Back");

		List<String> itemMenu = Arrays.asList("createItemsTable", "1.insertIntoItemsTable", "2.Delete Items",
				"3.Change Item Price", "4.Report All Items ", "5.Go Back");
				

		switch (option) {
		case 1:
			printMenu(MainMenu);
			break;
		case 2:
			printMenu(shopMenu);
			break;
		case 3:
			printMenu(itemMenu);

			break;

		}
		
		
	}
	
	public static void printMenu(List<String> printMenu){
		for(String x:printMenu) {
			
			System.out.println(x);

		}
		
		
	}

}