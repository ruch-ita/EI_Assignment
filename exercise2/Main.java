import services.ScheduleManager;
import services.TaskFactory;
import models.Task;
import utils.Logger;
import utils.ErrorHandler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        

        while (true) {
            System.out.println("1. Add Task\n2. Remove Task\n3. View Tasks\n4. Exit");
            int choice = scanner.nextInt();
            
            scanner.nextLine();
            

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter task details (description, start time, end time, priority): ");
                        String description = scanner.nextLine();
                        String startTime = scanner.nextLine();
                        String endTime = scanner.nextLine();
                        String priority = scanner.nextLine();

                        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
                        manager.addTask(task);
                        Logger.log("Task added: " + description);
                        break;
                    case 2:
                        System.out.println("Enter task description to remove: ");
                        description = scanner.nextLine();
                        manager.removeTask(description);
                        Logger.log("Task removed: " + description);
                        break;
                    case 3:
                        System.out.println("Scheduled Tasks:");
                        for (Task t : manager.getTasks()) {
                            System.out.println(t);
                        }
                        break;
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                ErrorHandler.handleError(e);
            }
        }
    }
}
