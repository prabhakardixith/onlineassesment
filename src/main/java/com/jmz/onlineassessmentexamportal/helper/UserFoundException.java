package com.jmz.onlineassessmentexamportal.helper;

public class UserFoundException extends Exception
{
    public UserFoundException() {
        super("User with this username is already there in db");
    }

    public UserFoundException(String message) {
        super(message);
    }
}
