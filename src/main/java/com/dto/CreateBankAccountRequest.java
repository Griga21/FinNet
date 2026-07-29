package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CreateBankAccountRequest {
    private String accountNumber;
    private BigDecimal accountBalance;
}
