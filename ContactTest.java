import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Verifies that Contact objects accept valid data and reject values that
 * violate the required field constraints.
 */
class ContactTest {

    // Creates a reusable valid contact so individual tests can focus on one rule.
    private Contact createValidContact() {
        return new Contact(
                "1234567890",
                "John",
                "Smith",
                "6035551234",
                "123 Main Street");
    }

    // Confirms that valid constructor values are stored correctly.
    @Test
    void testContactCreation() {
        Contact contact = createValidContact();

        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("6035551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    // Tests the contact ID boundary and null requirements.
    @Test
    void testContactIdExactlyTenCharacters() {
        Contact contact = new Contact(
                "ABCDEFGHIJ", "John", "Smith", "6035551234", "123 Main Street");

        assertEquals("ABCDEFGHIJ", contact.getContactId());
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ABCDEFGHIJK", "John", "Smith", "6035551234", "123 Main Street"));
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Smith", "6035551234", "123 Main Street"));
    }

    // Tests first-name length, null handling, and valid updates.
    @Test
    void testFirstNameExactlyTenCharacters() {
        Contact contact = new Contact(
                "12345", "ABCDEFGHIJ", "Smith", "6035551234", "123 Main Street");

        assertEquals("ABCDEFGHIJ", contact.getFirstName());
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "ABCDEFGHIJK", "Smith", "6035551234", "123 Main Street"));
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Smith", "6035551234", "123 Main Street"));
    }

    @Test
    void testSetFirstName() {
        Contact contact = createValidContact();

        contact.setFirstName("James");

        assertEquals("James", contact.getFirstName());
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("ABCDEFGHIJK"));
    }

    @Test
    void testSetFirstNameNull() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    // Tests last-name length, null handling, and valid updates.
    @Test
    void testLastNameExactlyTenCharacters() {
        Contact contact = new Contact(
                "12345", "John", "ABCDEFGHIJ", "6035551234", "123 Main Street");

        assertEquals("ABCDEFGHIJ", contact.getLastName());
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "ABCDEFGHIJK", "6035551234", "123 Main Street"));
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", null, "6035551234", "123 Main Street"));
    }

    @Test
    void testSetLastName() {
        Contact contact = createValidContact();

        contact.setLastName("Jones");

        assertEquals("Jones", contact.getLastName());
    }

    @Test
    void testSetLastNameTooLong() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ABCDEFGHIJK"));
    }

    @Test
    void testSetLastNameNull() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    // Verifies that phone numbers contain exactly 10 numeric digits.
    @Test
    void testPhoneValid() {
        Contact contact = createValidContact();

        assertEquals("6035551234", contact.getPhone());
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith", "603555123", "123 Main Street"));
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith", "60355512345", "123 Main Street"));
    }

    @Test
    void testPhoneContainsLetters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith", "60355512AB", "123 Main Street"));
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith", null, "123 Main Street"));
    }

    @Test
    void testSetPhone() {
        Contact contact = createValidContact();

        contact.setPhone("6035559876");

        assertEquals("6035559876", contact.getPhone());
    }

    @Test
    void testSetPhoneInvalid() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
    }

    // Tests the 30-character address boundary, null handling, and updates.
    @Test
    void testAddressExactlyThirtyCharacters() {
        String address = "A".repeat(30);
        Contact contact = new Contact(
                "12345", "John", "Smith", "6035551234", address);

        assertEquals(address, contact.getAddress());
    }

    @Test
    void testAddressTooLong() {
        String address = "A".repeat(31);

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith", "6035551234", address));
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Smith", "6035551234", null));
    }

    @Test
    void testSetAddress() {
        Contact contact = createValidContact();

        contact.setAddress("456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }

    @Test
    void testSetAddressTooLong() {
        Contact contact = createValidContact();
        String address = "A".repeat(31);

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(address));
    }

    @Test
    void testSetAddressNull() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
