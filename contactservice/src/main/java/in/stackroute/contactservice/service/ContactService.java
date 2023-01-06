package in.stackroute.contactservice.service;



import in.stackroute.contactservice.exceptions.ContactExistsException;
import in.stackroute.contactservice.exceptions.ContactNotFoundException;
import in.stackroute.contactservice.model.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getAllContacts(String email);
    public Contact addContact(Contact contact,String UserEmail) throws ContactExistsException;
    public void deleteContact(String contactId) throws ContactNotFoundException;
    public Contact getContactByEmail(String email) throws ContactNotFoundException;
    public List<Contact> getAllcontactsByCategory(String category);
//    public Contact  editContact(Contact newContact,String contactId) throws ContactNotFoundException;

    List<Contact> getContactsForUser(String userEmail);
}
