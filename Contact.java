/**
 * Represents a contact and enforces the validation rules required by the
 * contact service. The contact ID is immutable after the object is created.
 */
public class Contact {

    // Stores the unique, non-updatable identifier for the contact.
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Creates a contact after validating each required field.
     */
    public Contact(String contactId,
                   String firstName,
                   String lastName,
                   String phone,
                   String address) {
        // Validate all input before assigning values to the object.
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Accessor methods return the current values stored in the contact.
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Update methods validate new values before modifying the contact.
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Ensures the contact ID is present and does not exceed 10 characters.
    private static void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                    "Contact ID must not be null and must be 10 characters or fewer");
        }
    }

    // Ensures the first name is present and does not exceed 10 characters.
    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                    "First name must not be null and must be 10 characters or fewer");
        }
    }

    // Ensures the last name is present and does not exceed 10 characters.
    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                    "Last name must not be null and must be 10 characters or fewer");
        }
    }

    // Requires a non-null phone number containing exactly 10 numeric digits.
    private static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "Phone number must not be null and must contain exactly 10 digits");
        }
    }

    // Ensures the address is present and does not exceed 30 characters.
    private static void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                    "Address must not be null and must be 30 characters or fewer");
        }
    }
}
