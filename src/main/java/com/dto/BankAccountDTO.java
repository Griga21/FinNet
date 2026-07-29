package com.dto;

import java.math.BigDecimal;

public class BankAccountDTO {
    private final Long id;
    private BigDecimal accountBalance;
    private String accountNumber;

    public BankAccountDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
