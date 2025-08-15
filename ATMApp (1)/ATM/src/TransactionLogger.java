import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private List<Activity> activityLog;

    public TransactionLogger() {
        activityLog = new ArrayList<>();
    }

    public void record(String action, double value) {
        activityLog.add(new Activity(action, value));
    }

    public void display() {
        if (activityLog.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            System.out.println("Your Transaction Log:");
            for (Activity entry : activityLog) {
                System.out.println(entry);
            }
        }
    }
}
