public class BankAccount {
    private String username;
    private String password;
    private double currentBalance;

    public BankAccount(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.currentBalance = initialBalance;
    }

    public boolean verifyCredentials(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public double checkBalance() {
        return currentBalance;
    }

    public void addFunds(double amount) {
        currentBalance += amount;
    }

    public void deductFunds(double amount) {
        currentBalance -= amount;
    }

    public boolean canWithdraw(double amount) {
        return currentBalance >= amount;
    }
}
