package com.jmconsultant.testautomation.seleniumframeworkpoc.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
