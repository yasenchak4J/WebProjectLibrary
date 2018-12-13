package by.yasenchak.library_epam.exception.dao_exception;

public class RegistrationException extends Exception {
    private static final long serialVersionUID = -639553878582967891L;

    public RegistrationException(String msg){
        super(msg);
    }

    public RegistrationException(String msg, Exception e){
        super(msg, e);
    }
}
