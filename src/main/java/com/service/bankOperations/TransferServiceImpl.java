package com.service.bankOperations;

import com.entity.BankAccount;
import com.entity.TransactionStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService{
    @Override
    public TransactionStatus transferFunds(BankAccount bankAccountFrom, BankAccount bankAccountTo, BigDecimal amount) {
        bankAccountFrom.setAccountBalance(bankAccountFrom.getAccountBalance().subtract(amount));
        bankAccountTo.setAccountBalance(bankAccountTo.getAccountBalance().add(amount));
        return TransactionStatus.COMPLETED;
    }
}
