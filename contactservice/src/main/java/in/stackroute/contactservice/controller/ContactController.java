package in.stackroute.contactservice.controller;


import in.stackroute.contactservice.exceptions.ContactExistsException;
import in.stackroute.contactservice.exceptions.ContactNotFoundException;
import in.stackroute.contactservice.model.Contact;
import in.stackroute.contactservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/api/v1")
public class ContactController {

//    @Autowired
//    private ContactRepository repository;//has-a

    @Autowired
    private ContactService service;

    @GetMapping("/contacts/info")
    public String apinfo() {
        return "Contact API is running";
    }

    @GetMapping("/newinfo")
    public String newapifo() {
        return "New Contact API running";
    }

    @GetMapping("/contacts")
    public List<Contact> getAllcontacts(@RequestHeader String email) {
        return service.getAllContacts(email);
    }

//    @PostMapping("/contacts")
//    @ResponseStatus(HttpStatus.CREATED)//201
//    public Contact addContact(@RequestBody Contact newContact) {
//        return repository.addContact(newContact);
//    }

    //Getting the contact by email - HttpStatus.OK
    @GetMapping("/contacts/{email}")
    public Contact getContactByEmail (@PathVariable String email) throws ContactNotFoundException {
        return service.getContactByEmail(email);
    }

    @GetMapping(path = "/contacts", params = "category")
    public List<Contact> getAllcontactsByCategory(@RequestParam String category){
    return service.getAllcontactsByCategory(category);
    }



    @PostMapping("/contacts")
    public ResponseEntity<Contact> addContact(@RequestBody Contact newContact,@RequestHeader String email) throws ContactExistsException {
        Contact contact = service.addContact(newContact,email);
        return new ResponseEntity<>(contact,HttpStatus.CREATED);
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable String id) throws ContactNotFoundException {
        service.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/contacts/{id}")
//    public ResponseEntity<Contact> editContact(@RequestBody Contact newContact, @PathVariable String id) throws ContactNotFoundException {
//        Contact updatedContact = service.editContact(newContact, id);
//        return new ResponseEntity<>(updatedContact,HttpStatus.OK);
//    }

// implement get mapping for getting the contacts for specific user

}
