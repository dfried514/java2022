import java.util.Date;
import java.text.SimpleDateFormat;

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Welcome, %s.  So nice to see you.", name);
    }

    public String guestGreeting(String name, String dayPeriod) {
	if (dayPeriod.equals("morning"))
		return String.format("Good morning, %s.  Good to see you.", name);
	else if (dayPeriod.equals("afternoon"))
		return String.format("Good afternoon, %s. Have a wonderful day.", name);
	else if (dayPeriod.equals("evening"))
		return String.format("Good evening, %s. Have a great night.", name);
	else
		return this.guestGreeting(name);
    }
    
    public String dateAnnouncement() {
        SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
	String formattedDate = df.format(new Date());
	return String.format("It is currently %s.", formattedDate);
    }
    
    public String respondBeforeAlexis(String conversation) {
	if (conversation.contains("Alexis")) 
		return "Coming right now.  She is not sophisticated enough to know.";
	else if (conversation.contains("Alfred"))
		return "As you wish, at your service sir.";
	else 
		return "Right.  And with that I shall retire.";
    }

    public String angryGreeting(String name) {
	return String.format("Damnit, %s!  What were you thinking?!!", name);
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}


