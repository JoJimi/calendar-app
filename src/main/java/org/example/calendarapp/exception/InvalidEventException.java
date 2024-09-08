package org.example.calendarapp.exception;

public class InvalidEventException extends RuntimeException{
    public InvalidEventException(String message){
        super(message);
    }
}
