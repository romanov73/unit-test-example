package ru.ulstu.exception;

public class UserNotValidException extends Exception {
    public enum Code {
        EMPTY_LOGIN
    }

    private final Code code;

    public UserNotValidException(String message, Code code) {
        super(message);
        this.code = code;
    }

    public Code getCode() {
        return code;
    }
}
