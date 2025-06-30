import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

// Basic class setup for TaskServiceTest
public class TaskServiceTest {

    private static final String VALID_ID = "task001";
    private static final String VALID_NAME = "Test Task";
    private static final String VALID_DESC = "Task description";

    private static final String UPDATED_NAME = "Updated Task";
    private static final String UPDATED_DESC = "Updated description";

    // Test case: public void testAddTask_withValidTask_addsSuccessfully()
    @Test
    public void testAddTask_withValidTask_addsSuccessfully() {
        // Arrange
        TaskService service = new TaskService();
        Task task = new Task(VALID_ID, VALID_NAME, VALID_DESC);

        // Act
        service.addTask(task);
        Task result = service.getTask(VALID_ID);

        // Assert
        assertEquals(task, result);
    }

    // Test case: public void testAddTask_withDuplicateId_throwsException()
    @Test
    public void testAddTask_withDuplicateId_throwsException() {
        // Arrange
        TaskService service = new TaskService();
        Task task1 = new Task(VALID_ID, VALID_NAME, VALID_DESC);
        Task task2 = new Task(VALID_ID, "Other", "Other desc");

        // Act
        service.addTask(task1);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    // Test case: public void testGetTask_withNonexistentId_returnsNull()
    @Test
    public void testGetTask_withNonexistentId_returnsNull() {
        // Arrange
        TaskService service = new TaskService();

        // Act
        Task result = service.getTask("nonexistent");

        // Assert
        assertNull(result);
    }

    // Test case: public void testDeleteTask_withValidId_deletesSuccessfully()
    @Test
    public void testDeleteTask_withValidId_deletesSuccessfully() {
        // Arrange
        TaskService service = new TaskService();
        Task task = new Task(VALID_ID, VALID_NAME, VALID_DESC);
        service.addTask(task);

        // Act
        service.deleteTask(VALID_ID);
        Task result = service.getTask(VALID_ID);

        // Assert
        assertNull(result);
    }

    // Test case: public void testDeleteTask_withInvalidId_throwsException()
    @Test
    public void testDeleteTask_withInvalidId_throwsException() {
        // Arrange
        TaskService service = new TaskService();

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            service.deleteTask("notreal");
        });
    }

    // Test case: public void testUpdateTask_withValidTask_updatesSuccessfully()
    @Test
    public void testUpdateTask_withValidTask_updatesSuccessfully() {
        // Arrange
        TaskService service = new TaskService();
        Task original = new Task(VALID_ID, VALID_NAME, VALID_DESC);
        service.addTask(original);
        Task updated = new Task(VALID_ID, UPDATED_NAME, UPDATED_DESC);

        // Act
        service.updateTask(updated);
        Task result = service.getTask(VALID_ID);

        // Assert
        assertEquals(updated, result);
    }

    // Test case: public void testUpdateTask_withNonexistentTask_throwsException()
    @Test
    public void testUpdateTask_withNonexistentTask_throwsException() {
        // Arrange
        TaskService service = new TaskService();
        Task fake = new Task("fakeId", "X", "Y");

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            service.updateTask(fake);
        });
    }
}
