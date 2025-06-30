import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


// Basic service setup for AppointmentService
public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Method: public void addAppointment(Appointment appointment) — adds a new appointment
    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment already exists or is null");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Method: public Appointment getAppointment(String id) — returns a copy of the appointment
    public Appointment getAppointment(String appointmentId) {
        Appointment original = appointments.get(appointmentId);
        if (original == null) return null;
        return new Appointment(original.getAppointmentId(), original.getAppointmentDate(), original.getDescription());
    }

    // Method: public void deleteAppointment(String id) — deletes an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new NoSuchElementException("Appointment not found");
        }
        appointments.remove(appointmentId);
    }

    // Method: public void updateAppointment(Appointment updatedAppointment) — replaces an existing appointment
    public void updateAppointment(Appointment updatedAppointment) {
        if (updatedAppointment == null || !appointments.containsKey(updatedAppointment.getAppointmentId())) {
            throw new NoSuchElementException("Appointment not found");
        }
        appointments.put(updatedAppointment.getAppointmentId(), updatedAppointment);
    }
}