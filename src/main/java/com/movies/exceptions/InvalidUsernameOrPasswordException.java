package com.movies.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException (String message) {
        super(message);
    }
}
