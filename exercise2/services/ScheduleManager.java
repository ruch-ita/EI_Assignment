package services;

import models.Task;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance = null;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) throws Exception {
        if (hasConflict(task)) {
            throw new Exception("Task conflicts with existing tasks.");
        }
        tasks.add(task);
    }

    public void removeTask(String description) throws Exception {
        Task task = findTaskByDescription(description);
        if (task != null) {
            tasks.remove(task);
        } else {
            throw new Exception("Task not found.");
        }
    }

    public List<Task> getTasks() {
        tasks.sort((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        return tasks;
    }

    private boolean hasConflict(Task newTask) {
        for (Task task : tasks) {
            if (timeOverlap(newTask, task)) {
                return true;
            }
        }
        return false;
    }

    private boolean timeOverlap(Task newTask, Task existingTask) {
        // Logic to check if time overlaps
        return false;  // Placeholder
    }

    private Task findTaskByDescription(String description) {
        return tasks.stream().filter(t -> t.getStartTime().equals(description)).findFirst().orElse(null);
    }
}
