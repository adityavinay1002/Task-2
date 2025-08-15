import java.util.Scanner;

public class ATMService {
    private BankAccount userAccount;
    private TransactionLogger logger;
    private Scanner input;

    public ATMService(BankAccount userAccount, TransactionLogger logger) {
        this.userAccount = userAccount;
        this.logger = logger;
        this.input = new Scanner(System.in);
    }

    public void performWithdrawal() {
        System.out.print("Enter withdrawal amount: ");
        double amount = input.nextDouble();

        if (amount > 0 && userAccount.canWithdraw(amount)) {
            userAccount.deductFunds(amount);
            logger.record("Withdrawal", amount);
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Error: Insufficient funds or invalid input.");
        }
    }

    public void performDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            userAccount.addFunds(amount);
            logger.record("Deposit", amount);
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Error: Please enter a valid amount.");
        }
    }

    public void performTransfer() {
        System.out.print("Enter recipient ID: ");
        String recipientId = input.next(); 
        System.out.print("Enter amount to transfer: ");
        double amount = input.nextDouble();

        if (amount > 0 && userAccount.canWithdraw(amount)) {
            userAccount.deductFunds(amount);
            logger.record("Transfer to " + recipientId, amount);
            System.out.println("Transferred $" + amount + " to " + recipientId);
        } else {
            System.out.println("Transfer failed: Check amount or balance.");
        }
    }

    public void showBalance() {
        System.out.printf("Available balance: $%.2f%n", userAccount.checkBalance());
    }
}
