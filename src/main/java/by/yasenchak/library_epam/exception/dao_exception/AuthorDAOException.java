package by.yasenchak.library_epam.exception.dao_exception;

public class AuthorDAOException extends Exception{
    private static final long serialVersionUID = -4571286474526757695L;

    public AuthorDAOException(String msg){
        super(msg);
    }

    public AuthorDAOException(String msg, Exception e){
        super(msg, e);
    }
}
