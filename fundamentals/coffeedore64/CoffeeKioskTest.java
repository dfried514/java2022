public class CoffeeKioskTest {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        kiosk.addMenuItem("drip coffee", 4.5);
        kiosk.addMenuItem(new Item("latte", 5.5));
        kiosk.displayMenu();

        kiosk.addMenuItemsByInput();
        kiosk.displayMenu();

        kiosk.newOrders();
        kiosk.displayOrders();

        kiosk.closeScanner();
    }
}