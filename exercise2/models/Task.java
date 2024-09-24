package models;

public class Task {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;
    private boolean isCompleted;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public void editTask(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]";
    }
}
