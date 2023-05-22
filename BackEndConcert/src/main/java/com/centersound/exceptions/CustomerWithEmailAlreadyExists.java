package com.centersound.exceptions;

public class CustomerWithEmailAlreadyExists extends Exception{
    private static final long serialVersionUID = 7001746976620554755L;
    public CustomerWithEmailAlreadyExists(String mail) {
        super("Customer with mail already exists! - "+mail);
    }

}
