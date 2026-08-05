package com.dto;

import com.entity.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CreateTransactionRequest {
    Long fromAccountId;
    Long toAccountId;
    TransactionType type;
    BigDecimal amount;
}
