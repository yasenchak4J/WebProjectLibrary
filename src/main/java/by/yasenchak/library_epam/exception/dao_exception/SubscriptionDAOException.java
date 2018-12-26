package by.yasenchak.library_epam.exception.dao_exception;

public class SubscriptionDAOException extends Exception {
    private static final long serialVersionUID = -1494806040621934773L;

    public SubscriptionDAOException(String msg){
        super(msg);
    }

    public SubscriptionDAOException(String msg, Exception e){
        super(msg, e);
    }
}
