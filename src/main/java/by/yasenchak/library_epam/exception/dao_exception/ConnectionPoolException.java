package by.yasenchak.library_epam.exception.dao_exception;

public class ConnectionPoolException extends Exception {

    private static final long serialVersionUID = 7569052361456283899L;

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }

}
