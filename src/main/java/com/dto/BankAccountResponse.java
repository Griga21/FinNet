package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BankAccountResponse {
    private String accountNumber;
    private BigDecimal accountBalance;
}
