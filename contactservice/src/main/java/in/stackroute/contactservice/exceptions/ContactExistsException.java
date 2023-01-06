package in.stackroute.contactservice.exceptions;

//@ResponseStatus(value = HttpStatus.CONFLICT,reason = "contact already exists")
public class ContactExistsException extends Exception{
    public ContactExistsException(String message) {
        super(message);
    }

}
