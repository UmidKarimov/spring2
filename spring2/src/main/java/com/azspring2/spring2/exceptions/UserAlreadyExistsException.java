package com.azspring2.spring2.exceptions;

public class UserAlreadyExistsException  extends Exception{
    public UserAlreadyExistsException (String message) {
        super(message);
    }
}
