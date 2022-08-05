import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    private Scanner scanner;

    public CoffeeKiosk() {
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
        scanner = new Scanner(System.in);
    }                      
    public void addMenuItem(String name, double price) {
        menu.add(new Item(name, price));
    }
    public void addMenuItem(Item item) {
        menu.add(item);
    }
    public void addMenuItemsByInput() {
        System.out.println("Enter menu item ('q' to quit):");
        String name = scanner.nextLine();

        while (!name.equals("q")) {
            System.out.println("Enter price:");
            String price = scanner.nextLine();
            menu.add(new Item(name, Double.parseDouble(price)));
            System.out.println("Enter menu item ('q' to quit):");
            name = scanner.nextLine();
        }
    }
    public void displayMenu() {
        System.out.println("---Coffee Kisok Menu---");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d %s -- $%.2f%n", i, menu.get(i).getName(), menu.get(i).getPrice());
        }
    }
    public void newOrders() {
        System.out.println("Please enter customer name for new order ('q' to quit):");
        String name = scanner.nextLine();
        
        while (!name.equals("q")) {
            Order curOrder = new Order(name);
            System.out.println("Welcome, " + name);
            displayMenu();
            System.out.println("Enter a menu item index ('q' to quit):");
            String menuIndex = scanner.nextLine();

            while (!menuIndex.equals("q")) {
                curOrder.addItem(menu.get(Integer.parseInt(menuIndex)));       
                System.out.println("Enter a menu item index ('q' to quit):");
                menuIndex = scanner.nextLine();
            }
            orders.add(curOrder);
            System.out.println("Please enter customer name for new order ('q' to quit):");
            name = scanner.nextLine();
        }
    }
    public void displayOrders() {
        for (Order order : orders) {
            System.out.println("Thank you for your order, " + order.getName());
            order.display();
        }
    }
    public void closeScanner() {
        scanner.close();
    }
}