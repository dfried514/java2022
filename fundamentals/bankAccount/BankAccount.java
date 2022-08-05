import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int numAccounts = 0;
    private static double totalBalance = 0;

    private static Random randomNumGenerator = new Random();
    private static String getAccountNumber() {
        String res = "";
        for (int i = 1; i <= 10; i++) {
            int randomDigit = Math.abs(randomNumGenerator.nextInt()) % 10;
            res += randomDigit;
        }
        return res;
    }

    public BankAccount() {
        accountNumber = getAccountNumber();
        checkingBalance = 0;
        savingsBalance = 0;

        numAccounts++;
    }
    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public void depositToChecking(double amount) {
        checkingBalance += amount;
        totalBalance += amount;
    }
    public void despositToSavings(double amount) {
        savingsBalance += amount;
        totalBalance += amount;
    }
    public double withdrawFromChecking(double amount) {
        if (amount > checkingBalance)
            return 0;
        totalBalance -= amount;
        checkingBalance -= amount;
        return amount;
    }
    public double withdrawFromSavings(double amount) {
        if (amount > savingsBalance)
            return 0;
        totalBalance -= amount;
        savingsBalance -= amount;
        return amount;
    }
    public double getTotalBalance() {
        return totalBalance;
    }
    public int getNumAccounts() {
        return numAccounts;
    }
    public String createAccountNumber() {
        return getAccountNumber();
    }
}
