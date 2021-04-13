package by.tms.project.exceptions;

public class LoginDuplicateException extends Exception{
    public LoginDuplicateException() {
    }

    @Override
    public String getMessage() {
        return "This username is already taken, try another one";
    }
}
