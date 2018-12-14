package by.yasenchak.library_epam.exception.dao_exception;

public class GenreDAOException extends Exception {
    private static final long serialVersionUID = -7147682434050971192L;

    public GenreDAOException(String msg){
        super(msg);
    }

    public GenreDAOException(String msg, Exception e){
        super(msg, e);
    }
}
