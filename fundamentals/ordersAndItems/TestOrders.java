import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        item1.name = "drip coffee";
        item1.price = 4;

        item2.name = "cappuccino";
        item2.price = 4.5;

        item3.name = "latte";
        item3.price = 4.5;

        item4.name = "mocha";
        item4.price = 5;

    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        order1.items = new ArrayList<Item>();
        order2.items = new ArrayList<Item>();
        order3.items = new ArrayList<Item>();
        order4.items = new ArrayList<Item>();
        
        order1.name = "Cindhuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";

        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item2);
        order3.total += item2.price;

        order4.items.add(item3);
        order4.total += item3.price;

        order1.ready = true;

        order4.items.add(item3);
        order4.items.add(item3);
        order4.total += (item3.price * 2);

        order2.ready = true;
    
        System.out.println(order1.total);

        System.out.format("Name: %s %n", order1.name);
        System.out.format("Total: %.2f %n", order1.total);
        System.out.format("Ready:  %b %n", order1.ready);

        System.out.format("Name: %s %n", order2.name);
        System.out.format("Total: %.2f %n", order2.total);
        System.out.format("Ready:  %b %n", order2.ready);

        System.out.format("Name: %s %n", order3.name);
        System.out.format("Total: %.2f %n", order3.total);
        System.out.format("Ready:  %b %n", order3.ready);

        System.out.format("Name: %s %n", order4.name);
        System.out.format("Total: %.2f %n", order4.total);
        System.out.format("Ready:  %b %n", order4.ready);
    }
}
