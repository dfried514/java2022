public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        System.out.println("account number generator test...");
        for (int i = 1; i <= 1000; i++) {
            String acctNum = account.createAccountNumber();
            if (acctNum.length() != 10)
                System.out.println("Bad account number:  " + acctNum);
        }
        System.out.println("account number generator passed...");

        BankAccount ba2 = new BankAccount();
        BankAccount ba3 = new BankAccount();

        ba2.depositToChecking(100);
        ba2.depositToChecking(200);
        ba2.despositToSavings(200);
        ba2.withdrawFromChecking(50);
        ba2.withdrawFromChecking(20);
        ba2.withdrawFromSavings(100);

        ba3.depositToChecking(200);
        ba3.despositToSavings(300);
        ba3.withdrawFromChecking(300);
        
        System.out.printf("ba2 checking balance: %.2f%n", ba2.getCheckingBalance());
        System.out.printf("ba2 savings balance:  %.2f%n", ba2.getSavingsBalance());
        System.out.printf("ba3 checking balance: %.2f%n", ba3.getCheckingBalance());
        System.out.printf("ba3 savings balance:  %.2f%n", ba3.getSavingsBalance());

        System.out.println("Number of accounts:  " + ba2.getNumAccounts());
        System.out.println("Total of balances:  " + ba3.getTotalBalance());
    }
}