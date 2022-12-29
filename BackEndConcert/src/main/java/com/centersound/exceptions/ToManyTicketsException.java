package com.centersound.exceptions;

public class ToManyTicketsException extends Exception{
    private static final long serialVersionUID = 7001746976620554755L;
    public ToManyTicketsException(Long quantity) {
        super("To many tickets!");
    }

}
