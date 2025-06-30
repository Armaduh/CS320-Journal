import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Basic class setup for TaskTest
public class TaskTest {

    private static final String VALID_ID = "123";
    private static final String VALID_NAME = "TaskName";
    private static final String VALID_DESCRIPTION = "Task description here.";

    @Test
// Test case: public void testTaskCreation_withValidId_setsCorrectly()
    public void testTaskCreation_withValidId_setsCorrectly() {
        Task task = new Task(VALID_ID, VALID_NAME, VALID_DESCRIPTION);
        assertEquals(VALID_ID, task.getTaskId());
    }

    @Test
// Test case: public void testTaskCreation_withValidName_setsCorrectly()
    public void testTaskCreation_withValidName_setsCorrectly() {
        Task task = new Task(VALID_ID, VALID_NAME, VALID_DESCRIPTION);
        assertEquals(VALID_NAME, task.getName());
    }

    @Test
// Test case: public void testTaskCreation_withValidDescription_setsCorrectly()
    public void testTaskCreation_withValidDescription_setsCorrectly() {
        Task task = new Task(VALID_ID, VALID_NAME, VALID_DESCRIPTION);
        assertEquals(VALID_DESCRIPTION, task.getDescription());
    }

    @Test
// Test case: public void testTaskCreation_withNullId_throwsException()
    public void testTaskCreation_withNullId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, VALID_NAME, VALID_DESCRIPTION));
    }

    @Test
// Test case: public void testTaskCreation_withTooLongId_throwsException()
    public void testTaskCreation_withTooLongId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", VALID_NAME, VALID_DESCRIPTION));
    }

    @Test
// Test case: public void testTaskCreation_withNullName_throwsException()
    public void testTaskCreation_withNullName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, null, VALID_DESCRIPTION));
    }

    @Test
// Test case: public void testTaskCreation_withTooLongName_throwsException()
    public void testTaskCreation_withTooLongName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, "ThisNameIsWayTooLongToBeValid", VALID_DESCRIPTION));
    }

    @Test
// Test case: public void testTaskCreation_withNullDescription_throwsException()
    public void testTaskCreation_withNullDescription_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, VALID_NAME, null));
    }

    @Test
// Test case: public void testTaskCreation_withTooLongDescription_throwsException()
    public void testTaskCreation_withTooLongDescription_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task(VALID_ID, VALID_NAME, "x".repeat(51)));
    }

    @Test
// Test case: public void testEquals_withIdenticalFields_returnsTrue()
    public void testEquals_withIdenticalFields_returnsTrue() {
        Task t1 = new Task(VALID_ID, VALID_NAME, VALID_DESCRIPTION);
        Task t2 = new Task(VALID_ID, VALID_NAME, VALID_DESCRIPTION);
        assertEquals(t1, t2);
    }
}