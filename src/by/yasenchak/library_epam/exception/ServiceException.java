package by.yasenchak.library_epam.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 615914176187934309L;

    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException(String msg, Exception e){
        super(msg, e);
    }
}
