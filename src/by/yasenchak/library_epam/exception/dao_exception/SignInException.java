package by.yasenchak.library_epam.exception.dao_exception;

public class SignInException extends Exception {
    private static final long serialVersionUID = -2008895439907064127L;

    public SignInException(String msg){
        super(msg);
    }

    public SignInException(String msg, Exception e){
        super(msg, e);
    }
}
