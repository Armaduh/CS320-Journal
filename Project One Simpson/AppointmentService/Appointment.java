import java.util.Date;
import java.util.Objects;

// Basic class setup for Appointment
public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    // Method: public Appointment(String id, Date date, String description) — creates Appointment with validation
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10)
            throw new IllegalArgumentException("Invalid appointment ID");
        if (appointmentDate == null || appointmentDate.before(new Date()))
            throw new IllegalArgumentException("Appointment date must be in the future or today");
        if (description == null || description.length() > 50)
            throw new IllegalArgumentException("Invalid description");
        this.appointmentId = appointmentId;
        this.appointmentDate = new Date(appointmentDate.getTime()); // defensive copy
        this.description = description;
    }

    // Method: public String getAppointmentId() — returns appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Method: public Date getAppointmentDate() — returns copy of appointment date
    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    // Method: public String getDescription() — returns appointment description
    public String getDescription() {
        return description;
    }

    // Method: public boolean equals(Object o) — compares appointments by value
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId) &&
               Objects.equals(appointmentDate, that.appointmentDate) &&
               Objects.equals(description, that.description);
    }

    // Method: public int hashCode() — generates consistent hash based on fields
    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, appointmentDate, description);
    }
}
