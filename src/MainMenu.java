import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Scanner sa = new Scanner(System.in);
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String username = "sa";
		String password = "root";
		boolean Mainmenu = true;
		boolean subMenue1 = true;
		boolean subMenue2 = true;
		
		System.out.print("Please Enter User Name: ");
		String user = sa.next();
		System.out.print("Please Enter Password: ");
		String pass = sa.next();
		if(!user.equalsIgnoreCase(username) || !pass.equalsIgnoreCase(password)) {
			Mainmenu = false;
			System.out.println("Wrong user or password");
		}
		while (Mainmenu) {
			Menu.showMenu(1);
			String bb = sa.next();
			int option = Integer.parseInt(bb);

			switch (option) {

			case 1:
				while (subMenue1) {
					Menu.showMenu(2);

					Scanner sc = new Scanner(System.in);

					String bb1 = sc.next();
					int options = Integer.parseInt(bb1);

					switch (options) {

					case 0:

						Shop shop = new Shop();
						shop.createShopTable();

						break;
					case 1:

						Invoice invoice = new Invoice();

						break;

					case 2:

						Item items = new Item();
						

					case 3:

						Shop Shop = new Shop();
						Shop.createShopTable();

						break;

					case 4:

						Shop shop1 = new Shop();
						shop1.insertDataToShopTable();

						break;

					case 5:

						subMenue1 = false;

						Mainmenu = true;

						break;
					}

				}
				subMenue1 = false;
				break;

			case 2:
				while (subMenue2) {
					Menu.showMenu(3);

					Scanner sc = new Scanner(System.in);
					String bb1 = sc.next();
					int options = Integer.parseInt(bb1);

					switch (options) {

					case 0:

				

						break;

					case 1:
						Item items2 = new Item();

						break;

					case 2:
						Item itemsDelete = new Item();
						itemsDelete.deleteByItems();

						break;

					case 3:
						Item itemsUpdate = new Item();
						itemsUpdate.updateByItems();

						break;

					case 4:
						Item items4 = new Item();
						items4.readFromTable();

						break;

					case 5:
						subMenue2 = false;
						Mainmenu = true;
						break;

					}
					break;
				}
				subMenue2 = false;

			case 3:

				Invoice invoice = new Invoice();
				invoice.createInvoiceTable();

				break;
			case 4:

				break;

			case 5:
				

				Invoice invoice5 = new Invoice();
				invoice5.readFromInvoiceTable();
				break;

			case 6:
				Invoice invoice6 = new Invoice();
				invoice6.getByIdInvoice();

				break;

			case 7:
				Item items = new Item();
				items.createItemsTable();

				break;

			case 8:
				Scanner sc = new Scanner(System.in);
				System.out.println("Are you sure you want to exit?");
				String left = sc.next();
				if (left.equals("yes")) {
					System.exit(0);
				} else {

					Mainmenu = true;
					subMenue1 = false;
					subMenue2 = false;
				}

				break;
			}

		}
		Mainmenu = false;

	}

}