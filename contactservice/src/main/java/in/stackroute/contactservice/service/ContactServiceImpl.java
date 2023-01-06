package in.stackroute.contactservice.service;

import in.stackroute.contactservice.exceptions.ContactExistsException;
import in.stackroute.contactservice.exceptions.ContactNotFoundException;
import in.stackroute.contactservice.model.Contact;
import in.stackroute.contactservice.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository repository;

    @Override
    public List<Contact> getAllContacts(String email) {
       return repository.findByUserEmail(email);
    }

    @Override
    public Contact addContact(Contact contact,String userEmail) throws ContactExistsException {
        Optional<Contact> optionalContact = repository.findByEmailAndUserEmail(contact.getEmail(), userEmail);

        if (optionalContact.isEmpty()){
            contact.setUserEmail(userEmail);
            return repository.save(contact);
        }else{
            throw new ContactExistsException("Contact with the given email already exixts");
        }


    }

    //Person A  ----> C;    Person B          ---> Person C
    @Override
    public void deleteContact(String contactId) throws ContactNotFoundException {
       if(repository.existsById(contactId)){
           repository.deleteById(contactId);
       }else{
           throw new ContactNotFoundException("Contact Not Found");
       }

    }

    @Override
    public Contact getContactByEmail(String email) throws ContactNotFoundException {
        Optional<Contact> OptionalContact = repository.findByEmail(email);
        return OptionalContact.orElseThrow(()->new ContactNotFoundException("Contact Not Found"));
    }

    @Override
    public List<Contact> getAllcontactsByCategory(String category) {
        return repository.findByCategory(category);

    }

    @Override
    public List<Contact> getContactsForUser(String userEmail) {
        return repository.findByUserEmail(userEmail);
    }

//    @Override
//    public Contact editContact(Contact newContact, String contactId) throws ContactNotFoundException {
//        return repository.
//    }
}
