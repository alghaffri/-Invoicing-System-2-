import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        boolean exit = false;

        while (!exit) {
            menu.showMenu();
            System.out.print("Select an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Shop Settings");
                    // TODO: Handle Shop Settings menu options
                    break;
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
        input.close();
    }
}
