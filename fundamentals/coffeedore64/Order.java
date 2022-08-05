import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }
    public Order() {
        this("Guest");
    }
    public String getName() {
        return name;
    }
    public boolean isReady() {
        return ready;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public void addItem(Item item) {
        this.items.add(item);
    }
    public double getOrderTotal() {
        double total = 0;
        for (Item i : items) {
            total += i.getPrice();
        }
        return total;
    }
    public void display() {
        System.out.println("Customer name:  " + name);
        for (Item item : items) {
            System.out.printf("%s -- $%.2f%n", item.getName(), item.getPrice());
        }
        System.out.printf("Order total: $%.2f%n%n", getOrderTotal());
    }
}
