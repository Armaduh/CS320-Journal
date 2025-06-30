import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Basic class setup for ContactTest
public class ContactTest {

    private static final String VALID_ID = "123";
    private static final String VALID_FIRST = "John";
    private static final String VALID_LAST = "Doe";
    private static final String VALID_PHONE = "1234567890";
    private static final String VALID_ADDRESS = "123 Main St";

    @Test
    // Test case: public void testContactCreation_withValidFields_returnsCorrectObject()
    public void testContactCreation_withValidFields_returnsCorrectObject() {
        Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        assertEquals(VALID_ID, contact.getContactId());
    }

    @Test
    // Test case: public void testSetFirstName_withValidInput_setsCorrectly()
    public void testSetFirstName_withValidInput_setsCorrectly() {
        Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    // Test case: public void testSetLastName_withValidInput_setsCorrectly()
    public void testSetLastName_withValidInput_setsCorrectly() {
        Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    // Test case: public void testSetPhone_withValidInput_setsCorrectly()
    public void testSetPhone_withValidInput_setsCorrectly() {
        Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    // Test case: public void testSetAddress_withValidInput_setsCorrectly()
    public void testSetAddress_withValidInput_setsCorrectly() {
        Contact contact = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    // Test case: public void testContactCreation_withTooLongId_throwsException()
    public void testContactCreation_withTooLongId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withShortPhone_throwsException()
    public void testContactCreation_withShortPhone_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, "1234", VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testEquals_withIdenticalContact_returnsTrue()
    public void testEquals_withIdenticalContact_returnsTrue() {
        Contact c1 = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        Contact c2 = new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        assertEquals(c1, c2);
    }

    @Test
    // Test case: public void testContactCreation_withNullId_throwsException()
    public void testContactCreation_withNullId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, VALID_FIRST, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withNullFirstName_throwsException()
    public void testContactCreation_withNullFirstName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, null, VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withTooLongFirstName_throwsException()
    public void testContactCreation_withTooLongFirstName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, "ThisIsTooLong", VALID_LAST, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withNullLastName_throwsException()
    public void testContactCreation_withNullLastName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST, null, VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withTooLongLastName_throwsException()
    public void testContactCreation_withTooLongLastName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST, "LastNameTooLong", VALID_PHONE, VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withNonDigitPhone_throwsException()
    public void testContactCreation_withNonDigitPhone_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, "123-456-7890", VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withNullPhone_throwsException()
    public void testContactCreation_withNullPhone_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, null, VALID_ADDRESS);
        });
    }

    @Test
    // Test case: public void testContactCreation_withNullAddress_throwsException()
    public void testContactCreation_withNullAddress_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, null);
        });
    }

    @Test
    // Test case: public void testContactCreation_withTooLongAddress_throwsException()
    public void testContactCreation_withTooLongAddress_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(VALID_ID, VALID_FIRST, VALID_LAST, VALID_PHONE, "1234567890123456789012345678901");
        });
    }
}
