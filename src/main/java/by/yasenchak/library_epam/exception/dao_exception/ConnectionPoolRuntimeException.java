package by.yasenchak.library_epam.exception.dao_exception;

public class ConnectionPoolRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 7538176919956817497L;

    public ConnectionPoolRuntimeException(String message) {
        super(message);
    }

    public ConnectionPoolRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolRuntimeException(Throwable cause) {
        super(cause);
    }

}
