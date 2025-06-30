import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// Basic class setup for TaskService
public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Method: public void addTask(Task task) — adds a new task
    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Invalid or duplicate task");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Method: public Task getTask(String id) — returns a copy of the task or null if not found
    public Task getTask(String taskId) {
        Task original = tasks.get(taskId);
        if (original == null) return null;
        return new Task(original.getTaskId(), original.getName(), original.getDescription());
    }

    // Method: public void deleteTask(String id) — deletes a task by ID or throws if not found
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new NoSuchElementException("Task not found");
        }
        tasks.remove(taskId);
    }

    // Method: public void updateTask(Task updatedTask) — updates task with new data or throws if not found
    public void updateTask(Task updatedTask) {
        if (updatedTask == null || !tasks.containsKey(updatedTask.getTaskId())) {
            throw new NoSuchElementException("Task not found");
        }
        tasks.put(updatedTask.getTaskId(), updatedTask);
    }
}
