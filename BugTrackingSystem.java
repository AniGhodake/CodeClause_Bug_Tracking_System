import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bug {
    private String title;
    private String description;
    private String status;

    public Bug(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "Open";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class BugTracker {
    private List<Bug> bugs;

    public BugTracker() {
        this.bugs = new ArrayList<>();
    }

    public void addBug(Bug bug) {
        bugs.add(bug);
    }

    public void displayBugs() {
        System.out.println("Bug List:");
        for (Bug bug : bugs) {
            System.out.println("Title: " + bug.getTitle());
            System.out.println("Description: " + bug.getDescription());
            System.out.println("Status: " + bug.getStatus());
            System.out.println();
        }
    }

    public void updateBugStatus(String title, String status) {
        for (Bug bug : bugs) {
            if (bug.getTitle().equals(title)) {
                bug.setStatus(status);
                break;
            }
        }
    }
}

public class BugTrackingSystem {
    public static void main(String[] args) {
        BugTracker bugTracker = new BugTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bug Tracking System");
            System.out.println("1. Add a Bug");
            System.out.println("2. Display Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter bug title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter bug description: ");
                    String description = scanner.nextLine();
                    Bug bug = new Bug(title, description);
                    bugTracker.addBug(bug);
                    System.out.println("Bug added successfully!");
                    break;
                case 2:
                    bugTracker.displayBugs();
                    break;
                case 3:
                    System.out.print("Enter bug title: ");
                    String bugTitle = scanner.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    bugTracker.updateBugStatus(bugTitle, newStatus);
                    System.out.println("Bug status updated successfully!");
                    break;
                case 4:
                    System.out.println("Exiting Bug Tracking System...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
