import java.util.HashMap;
import java.util.Map;

/**
 * Provides in-memory storage and management operations for Contact objects.
 * Contacts are indexed by their unique contact IDs for efficient access.
 */
public class ContactService {

    // Maps each unique contact ID to its corresponding Contact object.
    private final Map<String, Contact> contacts;

    /**
     * Initializes an empty in-memory contact collection.
     */
    public ContactService() {
        contacts = new HashMap<>();
    }

    /**
     * Adds a contact when the object is valid and its ID is not already stored.
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contactId, contact);
    }

    /**
     * Deletes the contact associated with the specified contact ID.
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactId);
    }

    // Update methods locate the contact by ID and delegate field validation
    // to the Contact object's setter methods.
    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    /**
     * Retrieves a contact by ID and reports an error when the ID is not found.
     */
    public Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        return contact;
    }
}
