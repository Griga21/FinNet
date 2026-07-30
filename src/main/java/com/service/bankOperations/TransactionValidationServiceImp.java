package com.service.bankOperations;

import com.entity.BankAccount;

import java.math.BigDecimal;

public class TransactionValidationServiceImp implements TransactionValidationService {
    @Override
    public boolean checkTransferEligibility(BankAccount bankAccount, BigDecimal bigDecimal) {
        return false;
    }
}
