package com.qatestlab.exceptions;

/**
 * Created by APopichenko on 23.02.2017.
 */
public class FreeAccountantNotFoundException extends RequiredlEmployeesNotFoundException {
    public FreeAccountantNotFoundException(String message) {
        super(message);
    }
}
