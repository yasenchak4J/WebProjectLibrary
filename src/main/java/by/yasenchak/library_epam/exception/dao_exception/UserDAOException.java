package by.yasenchak.library_epam.exception.dao_exception;

public class UserDAOException extends Exception {
    private static final long serialVersionUID = -2008895439907064127L;

    public UserDAOException(String msg){
        super(msg);
    }

    public UserDAOException(String msg, Exception e){
        super(msg, e);
    }
}
