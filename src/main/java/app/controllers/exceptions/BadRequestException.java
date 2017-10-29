package app.controllers.exceptions;

/**
 * Created by garrettmoore on 10/29/17.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super();
    }
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
