package app.exceptions;

/**
 * Created by garrettmoore on 10/29/17.
 */
public class NoContentException extends RuntimeException {
    public NoContentException() {
        super();
    }
    public NoContentException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoContentException(String message) {
        super(message);
    }
    public NoContentException(Throwable cause) {
        super(cause);
    }
}
