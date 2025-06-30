import java.util.Objects;

// Basic class setup for Task
public class Task {
    private final String taskId;
    private String name;
    private String description;

    // Method: public Task(String taskId, String name, String description) — creates Task with validation via setters
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        this.taskId = taskId;
        setName(name);
        setDescription(description);
    }

    // Method: public String getTaskId() — returns task ID
    public String getTaskId() {
        return taskId;
    }

    // Method: public String getName() — returns task name
    public String getName() {
        return name;
    }

    // Method: public void setName(String name) — sets name with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    // Method: public String getDescription() — returns task description
    public String getDescription() {
        return description;
    }

    // Method: public void setDescription(String description) — sets description with validation
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

    // Method: public boolean equals(Object o) — compares tasks by value
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return taskId.equals(task.taskId) &&
               name.equals(task.name) &&
               description.equals(task.description);
    }

    // Method: public int hashCode() — generates consistent hash based on fields
    @Override
    public int hashCode() {
        return Objects.hash(taskId, name, description);
    }
}
