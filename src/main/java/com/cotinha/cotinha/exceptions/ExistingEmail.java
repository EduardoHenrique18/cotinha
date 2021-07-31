package com.cotinha.cotinha.exceptions;

public class ExistingEmail extends Exception {
    private static final long serialVersionUDI = 1L;

    public ExistingEmail(String message){
        super(message);
    }
}
