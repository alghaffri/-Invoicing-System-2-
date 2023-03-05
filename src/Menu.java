import java.util.ArrayList;

public class Menu {
    private ArrayList<String> menuItems;

    public Menu() {
        menuItems = new ArrayList<String>();
        menuItems.add("Shop Settings");
        menuItems.add("Manage Shop Items");
        menuItems.add("Create New Invoice");
        menuItems.add("Report: Statistics");
        menuItems.add("Report: All Invoices");
        menuItems.add("Search Invoice");
        menuItems.add("Program Statistics");
        menuItems.add("Exit");
    }

    public void showMenu() {
        System.out.println("Application Main Menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + "-" + menuItems.get(i));
        }
    }

    public ArrayList<String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }
}
