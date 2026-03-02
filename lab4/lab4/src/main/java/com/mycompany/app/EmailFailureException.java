package com.mycompany.app;

public class EmailFailureException extends Exception{

    public EmailFailureException(String message){
        super("Email Failed!" + message);
    }

}
