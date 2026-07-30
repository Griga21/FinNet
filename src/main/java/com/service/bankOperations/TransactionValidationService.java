package com.service.bankOperations;

import com.entity.BankAccount;

import java.math.BigDecimal;

public interface TransactionValidationService  {
    boolean checkTransferEligibility(BankAccount bankAccount, BigDecimal bigDecimal);
}
