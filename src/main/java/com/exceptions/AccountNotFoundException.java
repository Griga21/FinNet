package com.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long accountId) {
        super("Bank account with id " + accountId + " was not found");
    }
}
