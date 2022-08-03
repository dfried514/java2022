import java.util.ArrayList;
import java.util.Scanner;

public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        int total = 0;
        for (int i = 1; i <= numWeeks; i++) {
            total += i;
        }
        return total;
    }
    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + ".");
        System.out.println("There are " + customers.size() + " people in front of you.");
        customers.add(userName);

        for (String c : customers) {
            System.out.println(c);
        }
    }
    public void printPriceChart(String product, double price, int maxQuantity) {
        double total = 0;
        double discount = 0.5;

        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            total += price;
            System.out.format("%d - $%.2f\n", i, total);
            total -= discount;
        }
    }
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) 
            return false;
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.format("%d %s -- $%.2f\n", i, menuItems.get(i), prices.get(i));
        }
        return true;
    }
    public void addCustomers() {
        ArrayList<String> customers = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name ('q' to quit):");
        String customer = scanner.nextLine();

        while (!customer.equals("q")) {
            customers.add(customer);
            System.out.println("Enter customer name ('q' to quit):");
            customer = scanner.nextLine();
        }
        scanner.close();
        for (String c : customers) {
            System.out.println(c);
        }
    }
}


