import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class ATMApp {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        BankAccount accountHolder = new BankAccount("Aditya", "1234", 1000.0);
        TransactionLogger transactionLog = new TransactionLogger();
        ATMService atmService = new ATMService(accountHolder, transactionLog);

        System.out.println("=== Welcome to the ATM System ===");

        System.out.print("Enter your User ID: ");
        String inputUserId = inputScanner.nextLine();

        System.out.print("Enter your PIN: ");
        String inputPin = inputScanner.nextLine();

        if (accountHolder.verifyCredentials(inputUserId, inputPin)) {
            int option;
            do {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. View Transaction Log");
                System.out.println("2. Withdraw Funds");
                System.out.println("3. Deposit Funds");
                System.out.println("4. Transfer Funds");
                System.out.println("5. Check Account Balance");
                System.out.println("6. Exit");

                System.out.print("Select an option (1-6): ");
                option = inputScanner.nextInt();

                switch (option) {
                    case 1:
                        transactionLog.display();
                        break;
                    case 2:
                        atmService.performWithdrawal();
                        break;
                    case 3:
                        atmService.performDeposit();
                        break;
                    case 4:
                        atmService.performTransfer();
                        break;
                    case 5:
                        atmService.showBalance();
                        break;
                    case 6:
                        System.out.println("Session ended. Thank you for using our ATM.");
                        break;
                    default:
                        System.out.println("Invalid selection. Please choose a valid option.");
                }

            } while (option != 6);
        } else {
            System.out.println("Login failed: Incorrect User ID or PIN.");
        }

        inputScanner.close();
    }
}
