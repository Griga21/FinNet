package com.exceptions;

public class DuplicateAccountNumberException extends RuntimeException {
    public DuplicateAccountNumberException(String accountNumber) {
        super("Bank account with number " + accountNumber + " already exists");
    }
}
