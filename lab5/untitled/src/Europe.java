import java.util.ArrayList;
import java.util.List;

public class Europe {
    private String name;
    private List<HistoryRecord> history;

    public Europe(String name) {
        this.name = name;
        this.history = new ArrayList<>();
    }

    public class HistoryRecord {
        private String period;
        private String description;

        public HistoryRecord(String period, String description) {
            this.period = period;
            this.description = description;
        }

        @Override
        public String toString() {
            return "[" + period + "]: " + description;
        }
    }

    public void addHistoryRecord(String period, String description) {
        HistoryRecord record = new HistoryRecord(period, description);
        history.add(record);
    }

    public void printHistory() {
        System.out.println("history of territorial division of " + name + ":");
        for (HistoryRecord record : history) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
        Europe europe = new Europe("europe");

        europe.addHistoryRecord("antiquity", "the roman empire controls the southern part.");
        europe.addHistoryRecord("middle ages", "feudal fragmentation, appearance of the holy roman empire.");
        europe.addHistoryRecord("late xx century", "dissolution of the ussr, yugoslavia, reunification of germany.");

        europe.printHistory();
        System.out.println("--------------------------------------------------");

        Runnable anonymousDemonstration = new Runnable() {
            @Override
            public void run() {
                System.out.println("message from anonymous class: analysis of geopolitical changes completed successfully!");
            }
        };

        anonymousDemonstration.run();
    }
}
