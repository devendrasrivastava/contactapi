package in.stackroute.contactservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandller {

    @ExceptionHandler(ContactExistsException.class)
    public ResponseEntity<?> handleContactExistsException(ContactExistsException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<?> handleContactNotFoundException(ContactNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }






}
