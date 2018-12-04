package by.yasenchak.library_epam.exception;

public class SignInException extends Exception {

    public SignInException(String msg){
        super(msg);
    }

    public SignInException(String msg, Exception e){
        super(msg, e);
    }
}
