import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// Basic class setup for ContactService
public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

// Method: public void addContact(Contact contact) — does what it sounds like
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

// Method: public Contact getContact(String contactId) — does what it sounds like
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new NoSuchElementException("Contact ID not found");
        }
        return contacts.get(contactId);
    }

// Method: public void deleteContact(String contactId) — does what it sounds like
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new NoSuchElementException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

// Method: public void updateContact(String contactId, String firstName, String lastName, String phone, String address) — does what it sounds like
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new NoSuchElementException("Contact ID not found");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
}