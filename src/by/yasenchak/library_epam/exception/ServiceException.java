package by.yasenchak.library_epam.exception;

public class ServiceException extends Exception {
    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException(String msg, Exception e){
        super(msg, e);
    }
}
