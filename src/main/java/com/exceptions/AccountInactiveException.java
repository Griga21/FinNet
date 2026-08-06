package com.exceptions;

public class AccountInactiveException extends RuntimeException {
    public AccountInactiveException() {
        super("Both bank accounts must be active");
    }
}
