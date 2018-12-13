package by.yasenchak.library_epam.exception.dao_exception;

public class LibraryDAOException extends Exception {
    private static final long serialVersionUID = 7924632029455321089L;

    public LibraryDAOException(String msg){
        super(msg);
    }

    public LibraryDAOException(String msg, Exception e){
        super(msg, e);
    }
}
