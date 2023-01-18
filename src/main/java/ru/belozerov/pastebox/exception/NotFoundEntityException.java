package ru.belozerov.pastebox.exception;

public class NotFoundEntityException extends RuntimeException{
    public NotFoundEntityException(String s){
        super(s);
    }
}
