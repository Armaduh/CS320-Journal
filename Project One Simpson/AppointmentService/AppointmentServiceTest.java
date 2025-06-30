import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;
import java.util.NoSuchElementException;

// Basic class setup for AppointmentServiceTest
public class AppointmentServiceTest {

    private static final String VALID_ID = "appt123";
    private static final String VALID_DESCRIPTION = "Dentist check-up";

    // Method: private Date getTodayDate() — returns current date at 12:00PM
    private Date getTodayDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // Method: private Date getFutureDate() — returns tomorrow's date
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    @Test
    // Test case: public void testAddAppointment_withValidData_addsSuccessfully()
    public void testAddAppointment_withValidData_addsSuccessfully() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(VALID_ID, getFutureDate(), VALID_DESCRIPTION);
        service.addAppointment(appointment);
        Appointment retrieved = service.getAppointment(VALID_ID);
        assertEquals(appointment, retrieved);
    }

    @Test
    // Test case: public void testDeleteAppointment_withValidId_deletesSuccessfully()
    public void testDeleteAppointment_withValidId_deletesSuccessfully() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(VALID_ID, getFutureDate(), VALID_DESCRIPTION);
        service.addAppointment(appointment);
        service.deleteAppointment(VALID_ID);
        assertNull(service.getAppointment(VALID_ID));
    }

    @Test
    // Test case: public void testDeleteAppointment_withInvalidId_throwsException()
    public void testDeleteAppointment_withInvalidId_throwsException() {
        AppointmentService service = new AppointmentService();
        assertThrows(NoSuchElementException.class, () -> {
            service.deleteAppointment("invalid");
        });
    }

    @Test
    // Test case: public void testUpdateAppointment_withValidData_updatesSuccessfully()
    public void testUpdateAppointment_withValidData_updatesSuccessfully() {
        AppointmentService service = new AppointmentService();
        Appointment oldAppt = new Appointment(VALID_ID, getFutureDate(), "Old desc");
        Appointment updatedAppt = new Appointment(VALID_ID, getFutureDate(), VALID_DESCRIPTION);
        service.addAppointment(oldAppt);
        service.updateAppointment(updatedAppt);
        assertEquals(updatedAppt, service.getAppointment(VALID_ID));
    }

    @Test
    // Test case: public void testUpdateAppointment_withInvalidId_throwsException()
    public void testUpdateAppointment_withInvalidId_throwsException() {
        AppointmentService service = new AppointmentService();
        Appointment fake = new Appointment("fakeId", getFutureDate(), "Desc");
        assertThrows(NoSuchElementException.class, () -> {
            service.updateAppointment(fake);
        });
    }

    @Test
    // Test case: public void testGetAppointment_withNonexistentId_returnsNull()
    public void testGetAppointment_withNonexistentId_returnsNull() {
        AppointmentService service = new AppointmentService();
        assertNull(service.getAppointment("nope"));
    }

    @Test
    // Test case: public void testAddAppointment_withDuplicateId_throwsException()
    public void testAddAppointment_withDuplicateId_throwsException() {
        AppointmentService service = new AppointmentService();
        Appointment appt1 = new Appointment(VALID_ID, getFutureDate(), "A");
        Appointment appt2 = new Appointment(VALID_ID, getFutureDate(), "B");
        service.addAppointment(appt1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appt2);
        });
    }

    @Test
    // Test case: public void testAddAppointment_withTodaysDate_succeeds()
    public void testAddAppointment_withTodaysDate_succeeds() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(VALID_ID, getTodayDate(), VALID_DESCRIPTION);
        service.addAppointment(appointment);
        Appointment retrieved = service.getAppointment(VALID_ID);
        assertEquals(getTodayDate(), retrieved.getAppointmentDate());
    }
}