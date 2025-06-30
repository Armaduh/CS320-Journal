import java.util.Objects;

// Basic class setup for Contact
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

// Method: public Contact(String contactId, String firstName, String lastName, String phone, String address) — does what it sounds like
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");
        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

// Method: public String getContactId() — does what it sounds like
    public String getContactId() { return contactId; }
// Method: public String getFirstName() — does what it sounds like
    public String getFirstName() { return firstName; }
// Method: public String getLastName() — does what it sounds like
    public String getLastName() { return lastName; }
// Method: public String getPhone() — does what it sounds like
    public String getPhone() { return phone; }
// Method: public String getAddress() — does what it sounds like
    public String getAddress() { return address; }

// Method: public void setFirstName(String firstName) — does what it sounds like
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

// Method: public void setLastName(String lastName) — does what it sounds like
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

// Method: public void setPhone(String phone) — does what it sounds like
    public void setPhone(String phone) {
    if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}"))
        throw new IllegalArgumentException("Invalid phone number");
    this.phone = phone;
}



// Method: public void setAddress(String address) — does what it sounds like
    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }

    @Override
// Method: public boolean equals(Object o) — does what it sounds like
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return contactId.equals(contact.contactId) &&
               firstName.equals(contact.firstName) &&
               lastName.equals(contact.lastName) &&
               phone.equals(contact.phone) &&
               address.equals(contact.address);
    }

    @Override
// Method: public int hashCode() — does what it sounds like
    public int hashCode() {
        return Objects.hash(contactId, firstName, lastName, phone, address);
    }
}