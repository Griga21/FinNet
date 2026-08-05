package com.service.bankOperations;

import com.entity.BankAccount;
import com.entity.TransactionStatus;

import java.math.BigDecimal;

public interface TransactionValidationService  {
    boolean checkTransferEligibility(BankAccount bankAccountFrom, BankAccount bankAccountTo, BigDecimal amount);
   }
