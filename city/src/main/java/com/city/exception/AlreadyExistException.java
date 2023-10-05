package com.city.exception;

public class AlreadyExistException extends Exception {
    private String message;

    public AlreadyExistException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
