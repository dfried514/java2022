import java.util.ArrayList;
import java.util.Collections;

public class TestCafe {
    /*
    * This main method will always be the launch point for a Java application
    * For now, we are using the main to test all our 
    * CafeUtil methods.
    */
    public static void main(String[] args) {
        // Make an instance of CafeUtil to access all its methods.
        CafeUtil cu = new CafeUtil();
        
        int numWeeks = 10;
        int streakGoal = cu.getStreakGoal(numWeeks);

        double[] prices = {3.25, 5.5, 2, 4.25};
        double orderTotal =  cu.getOrderTotal(prices);
        
        ArrayList<String> menuItems = new ArrayList<String>(); 
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");

        ArrayList<String> customers = new ArrayList<>();
        customers.add("Bill");
        customers.add("Sam");
        customers.add("Phil");
        customers.add("Tom");

        String product = "Columbian Coffee Grounds";
        double price = 2;
        int maxQuantity = 4;
        
        ArrayList<Double> pricesArrayList = new ArrayList<Double>();
        for (double d : prices) {
            pricesArrayList.add(d);
        }
        
        // Uncomment these one at a time as you implement each method.
        // System.out.println("Purchases needed by week " + numWeeks + ": " + streakGoal);
        //  System.out.format("Order total: $%.2f", orderTotal);
        // cu.displayMenu(menuItems);
        // cu.addCustomer(customers);
        // cu.printPriceChart(product, price, maxQuantity);
        // cu.displayMenu(menuItems, pricesArrayList);
        // cu.addCustomers();
    }
}
