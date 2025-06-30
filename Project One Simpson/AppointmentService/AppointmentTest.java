import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

// Basic class setup for AppointmentTest
public class AppointmentTest {

    private static final String VALID_ID = "1234567890";
    private static final String VALID_DESC = "Check-up appointment";

    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    @Test
// Test case: public void testAppointmentCreation_withValidId_setsCorrectly()
    public void testAppointmentCreation_withValidId_setsCorrectly() {
        Appointment appt = new Appointment(VALID_ID, getFutureDate(), VALID_DESC);
        assertEquals(VALID_ID, appt.getAppointmentId());
    }

    @Test
// Test case: public void testAppointmentCreation_withValidDescription_setsCorrectly()
    public void testAppointmentCreation_withValidDescription_setsCorrectly() {
        Appointment appt = new Appointment(VALID_ID, getFutureDate(), VALID_DESC);
        assertEquals(VALID_DESC, appt.getDescription());
    }

    @Test
// Test case: public void testAppointmentCreation_withValidDate_setsCorrectly()
    public void testAppointmentCreation_withValidDate_setsCorrectly() {
        Appointment appt = new Appointment(VALID_ID, getFutureDate(), VALID_DESC);
        assertNotNull(appt.getAppointmentDate());
    }

    @Test
// Test case: public void testAppointmentCreation_withTooLongId_throwsException()
    public void testAppointmentCreation_withTooLongId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", getFutureDate(), VALID_DESC);
        });
    }

    @Test
// Test case: public void testAppointmentCreation_withNullId_throwsException()
    public void testAppointmentCreation_withNullId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(), VALID_DESC);
        });
    }

    @Test
// Test case: public void testAppointmentCreation_withNullDate_throwsException()
    public void testAppointmentCreation_withNullDate_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(VALID_ID, null, VALID_DESC);
        });
    }

    @Test
// Test case: public void testAppointmentCreation_withPastDate_throwsException()
    public void testAppointmentCreation_withPastDate_throwsException() {
        Date pastDate = new Date(System.currentTimeMillis() - 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(VALID_ID, pastDate, VALID_DESC);
        });
    }

    @Test
// Test case: public void testAppointmentCreation_withNullDescription_throwsException()
    public void testAppointmentCreation_withNullDescription_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(VALID_ID, getFutureDate(), null);
        });
    }

    @Test
// Test case: public void testAppointmentCreation_withTooLongDescription_throwsException()
    public void testAppointmentCreation_withTooLongDescription_throwsException() {
        String longDescription = "A".repeat(51);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(VALID_ID, getFutureDate(), longDescription);
        });
    }

    @Test
// Test case: public void testEquals_withIdenticalAppointment_returnsTrue()
    public void testEquals_withIdenticalAppointment_returnsTrue() {
        Date futureDate = getFutureDate();
        Appointment a1 = new Appointment(VALID_ID, futureDate, VALID_DESC);
        Appointment a2 = new Appointment(VALID_ID, futureDate, VALID_DESC);
        assertEquals(a1, a2);
    }
}