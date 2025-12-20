package com.example.demo.exception;
public class InvalidMaxHoursException extends IllegalArgumentException{
    public InvalidMaxHoursException(String message){
        super(message);
    }
}
