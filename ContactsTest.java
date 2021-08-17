import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Test;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.contacts.Contact;
import com.flickr4java.flickr.contacts.ContactsInterface;

public class ContactsTest extends FlickrJavaTest{

    @Test
    public void testGetList() throws FlickrException {
        ContactsInterface intface = flickr.getContactsInterface();
        Collection<Contact> contacts = intface.getList();
        assertNotNull(contacts);
        assertTrue("No Contacts. (You need to have contacts for this test to succceed)", contacts.size() > 0);
        Iterator<Contact> it = contacts.iterator();
        for (int i = 0; it.hasNext() && i < 10; i++) {
            Contact contact = (Contact) it.next();
            assertNotNull(contact.getUsername());
            assertNotNull(contact.getRealName());
            assertNotNull(contact.getId());
            assertTrue(contact.getIconFarm() > 0);
            assertTrue(contact.getIconServer() > 0);
        }
    }

    @Test
    public void testGetPublicList() throws FlickrException {
        ContactsInterface intface = flickr.getContactsInterface();
        Collection<Contact> contacts = intface.getPublicList(testProperties.getNsid());
        assertNotNull(contacts);
        assertTrue("No Contacts. (You need to have contacts for this test to succceed)", contacts.size() > 0);
        Iterator<Contact> it = contacts.iterator();
        for (int i = 0; it.hasNext() && i < 10; i++) {
            Contact contact = (Contact) it.next();
            assertNotNull(contact.getUsername());
            assertNotNull(contact.getId());
            assertTrue(contact.getIconFarm() > 0);
            assertTrue(contact.getIconServer() > 0);
        }
    }

}
