import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Verifies that ContactService correctly adds, deletes, retrieves, and updates
 * contacts while enforcing unique contact IDs and Contact validation rules.
 */
class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    // Creates fresh test data before each test to keep test cases independent.
    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        contact = new Contact(
                "10001",
                "John",
                "Smith",
                "6035551234",
                "123 Main Street");
    }

    // Verifies that a valid contact can be added and retrieved by its ID.
    @Test
    void testAddContact() {
        contactService.addContact(contact);

        assertSame(contact, contactService.getContact("10001"));
    }

    // Verifies that duplicate IDs and null contacts are rejected.
    @Test
    void testAddDuplicateContactId() {
        Contact secondContact = new Contact(
                "10001",
                "Jane",
                "Jones",
                "6035559999",
                "456 Oak Street");

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class,
                () -> contactService.addContact(secondContact));
    }

    @Test
    void testAddNullContact() {
        assertThrows(IllegalArgumentException.class,
                () -> contactService.addContact(null));
    }

    // Verifies successful deletion and handling of unknown contact IDs.
    @Test
    void testDeleteContact() {
        contactService.addContact(contact);
        contactService.deleteContact("10001");

        assertThrows(IllegalArgumentException.class,
                () -> contactService.getContact("10001"));
    }

    @Test
    void testDeleteNonexistentContact() {
        assertThrows(IllegalArgumentException.class,
                () -> contactService.deleteContact("99999"));
    }

    // Verifies first-name updates and rejection of invalid first-name values.
    @Test
    void testUpdateFirstName() {
        contactService.addContact(contact);

        contactService.updateFirstName("10001", "James");

        assertEquals("James", contactService.getContact("10001").getFirstName());
    }

    @Test
    void testUpdateFirstNameInvalid() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateFirstName("10001", "ABCDEFGHIJK"));
    }

    // Verifies last-name updates and rejection of invalid last-name values.
    @Test
    void testUpdateLastName() {
        contactService.addContact(contact);

        contactService.updateLastName("10001", "Jones");

        assertEquals("Jones", contactService.getContact("10001").getLastName());
    }

    @Test
    void testUpdateLastNameInvalid() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateLastName("10001", "ABCDEFGHIJK"));
    }

    // Verifies phone updates and rejection of non-numeric phone values.
    @Test
    void testUpdatePhone() {
        contactService.addContact(contact);

        contactService.updatePhone("10001", "6035554321");

        assertEquals("6035554321", contactService.getContact("10001").getPhone());
    }

    @Test
    void testUpdatePhoneInvalid() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updatePhone("10001", "603555ABCD"));
    }

    // Verifies address updates and enforcement of the 30-character limit.
    @Test
    void testUpdateAddress() {
        contactService.addContact(contact);

        contactService.updateAddress("10001", "456 Oak Street");

        assertEquals("456 Oak Street", contactService.getContact("10001").getAddress());
    }

    @Test
    void testUpdateAddressInvalid() {
        contactService.addContact(contact);
        String invalidAddress = "A".repeat(31);

        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateAddress("10001", invalidAddress));
    }

    // Confirms that update operations fail when the requested contact is absent.
    @Test
    void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateFirstName("99999", "James"));
    }

    // Confirms that retrieval returns the same contact object that was stored.
    @Test
    void testGetContact() {
        contactService.addContact(contact);

        assertSame(contact, contactService.getContact("10001"));
    }
}
