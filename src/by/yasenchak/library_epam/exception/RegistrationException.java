package by.yasenchak.library_epam.exception;

public class RegistrationException extends Exception {

    public RegistrationException(String msg){
        super(msg);
    }

    public RegistrationException(String msg, Exception e){
        super(msg, e);
    }
}
