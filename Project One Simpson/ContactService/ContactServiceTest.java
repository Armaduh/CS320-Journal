import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

// Basic class setup for ContactServiceTest
public class ContactServiceTest {

    private static final String ID = "001";
    private static final String FIRST = "John";
    private static final String LAST = "Doe";
    private static final String PHONE = "1234567890";
    private static final String ADDRESS = "123 Main St";

    @Test
// Test case: public void testAddContact_withUniqueId_addsSuccessfully()
    public void testAddContact_withUniqueId_addsSuccessfully() {
        ContactService service = new ContactService();
        Contact contact = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(contact);
        Contact retrieved = service.getContact(ID);
        assertEquals(contact, retrieved);
    }

    @Test
// Test case: public void testAddContact_withDuplicateId_throwsException()
    public void testAddContact_withDuplicateId_throwsException() {
        ContactService service = new ContactService();
        Contact contact = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
// Test case: public void testDeleteContact_withValidId_removesContact()
    public void testDeleteContact_withValidId_removesContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(contact);
        service.deleteContact(ID);
        assertThrows(NoSuchElementException.class, () -> service.getContact(ID));
    }

    @Test
// Test case: public void testDeleteContact_withInvalidId_throwsException()
    public void testDeleteContact_withInvalidId_throwsException() {
        ContactService service = new ContactService();
        assertThrows(NoSuchElementException.class, () -> service.deleteContact("nonexistent"));
    }

    @Test
// Test case: public void testUpdateContact_withValidFields_updatesCorrectly()
    public void testUpdateContact_withValidFields_updatesCorrectly() {
        ContactService service = new ContactService();
        Contact contact = new Contact(ID, FIRST, LAST, PHONE, ADDRESS);
        service.addContact(contact);

        service.updateContact(ID, "Jane", "Smith", "0987654321", "456 Elm St");

        Contact updated = service.getContact(ID);
        Contact expected = new Contact(ID, "Jane", "Smith", "0987654321", "456 Elm St");

        assertEquals(expected, updated);
    }

    @Test
// Test case: public void testUpdateContact_withInvalidId_throwsException()
    public void testUpdateContact_withInvalidId_throwsException() {
        ContactService service = new ContactService();
        assertThrows(NoSuchElementException.class, () -> {
            service.updateContact("invalid", "Jane", "Smith", "0987654321", "456 Elm St");
        });
    }
}