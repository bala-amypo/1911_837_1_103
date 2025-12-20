package com.example.demo.exception;
public class InvalidTimeOrderException extends IllegalArgumentException{
    public InvalidTimeOrderException(String message){
        super(message);
    }
}
