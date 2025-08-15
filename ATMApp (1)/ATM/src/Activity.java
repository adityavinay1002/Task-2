import java.time.LocalDateTime;

public class Activity {
    private String actionType;
    private double transactionAmount;
    private LocalDateTime dateTime;

    public Activity(String actionType, double transactionAmount) {
        this.actionType = actionType;
        this.transactionAmount = transactionAmount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + dateTime + "] " + actionType + " of $" + transactionAmount;
    }
}
