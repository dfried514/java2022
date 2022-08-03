public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3;
	double dripCoffeePrice = 5;
	double lattePrice = 3.5;
	double cappuccinoPrice = 4;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
	String customer2 = "Sam";
	String customer3 = "Jimmy";
	String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
	boolean isReadyOrder2 = true;
	boolean isReadyOrder3 = false;
	boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
	System.out.println(customer1 + pendingMessage);
	System.out.println(displayTotalMessage + String.format("%.2f", dripCoffeePrice));

	System.out.println(generalGreeting + customer4);
	if (isReadyOrder4) {
		System.out.println(customer4 + readyMessage);
		System.out.println(displayTotalMessage + String.format("%.2f", cappuccinoPrice));
	} else {
		System.out.println(customer4 + pendingMessage);
	}
	
	System.out.println(generalGreeting + customer2);
	if (isReadyOrder2) {
		System.out.println(customer2 + readyMessage);
		System.out.println(displayTotalMessage + String.format("%.2f", (lattePrice * 2)));
	} else {
		System.out.println(customer2 + pendingMessage);
	}
	System.out.println(generalGreeting + customer3);
	System.out.println(displayTotalMessage + String.format("%.2f", (dripCoffeePrice - lattePrice)));
    }
}
