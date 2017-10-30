package app.controllers;

import app.exceptions.BadRequestException;
import app.exceptions.NoContentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity noContentHandler() {
        return new ResponseEntity("Nothing to see here", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity badRequestHandler() {
        return new ResponseEntity("Opps, you messed something up", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity generalHandler() {
        return new ResponseEntity("Opps, something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
