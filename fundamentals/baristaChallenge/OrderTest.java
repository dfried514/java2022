public class OrderTest {
    public static void main(String[] args) {
        Order guest1 = new Order();
        Order guest2 = new Order();
        Order dave = new Order("Dave");
        Order mark = new Order("Mark");
        Order phil = new Order("Phil");

        Item dripCoffee = new Item("drip coffee", 4.5);
        Item cappuccino = new Item("cappuccino", 5.5);
        Item latte = new Item("latte", 5.5);
        Item mocha = new Item("mocha", 6);

        guest1.addItem(dripCoffee);
        guest1.addItem(latte);

        guest2.addItem(dripCoffee);
        guest2.addItem(cappuccino);

        dave.addItem(dripCoffee);
        dave.addItem(mocha);

        mark.addItem(dripCoffee);
        mark.addItem(latte);
        mark.addItem(latte);

        phil.addItem(dripCoffee);
        phil.addItem(latte);
        phil.addItem(latte);
        phil.addItem(cappuccino);
        phil.addItem(mocha);

        guest1.setReady(true);
        dave.setReady(true);
        phil.setReady(true);

        System.out.println(guest1.getStatusMessage());
        System.out.println(guest2.getStatusMessage());
        System.out.println(dave.getStatusMessage());
        System.out.println(mark.getStatusMessage());
        System.out.println(phil.getStatusMessage());

        System.out.println(guest1.getOrderTotal());
        System.out.println(guest2.getOrderTotal());
        System.out.println(dave.getOrderTotal());
        System.out.println(mark.getOrderTotal());
        System.out.println(phil.getOrderTotal());

        guest1.display();
        guest2.display();
        dave.display();
        mark.display();
        phil.display();
    }
}