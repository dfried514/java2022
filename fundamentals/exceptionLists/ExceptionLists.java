import java.util.ArrayList;

public class ExceptionLists {
    public void exceptions() {
        ArrayList<Object> list = new ArrayList<Object>();

        list.add("43");
        list.add(32);
        list.add("One, two");
        list.add("Hello, world");

        for (int i = 0; i < list.size(); i++) {
            try {
                Integer castedValue = (Integer)list.get(i);
            } catch (ClassCastException e) {
                System.out.println("At index " + i + ": ClassCastException: " + list.get(i) + ", " + e.getMessage());
            }
        }
    }
}