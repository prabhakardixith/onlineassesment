package com.jmz.onlineassessmentexamportal.helper;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException() {
        super("User with this username not found in database");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
