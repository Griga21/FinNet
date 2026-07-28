package com.service;

import com.entity.BankAccount;
import com.entity.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    Long createTransaction(BankAccount bankAccount);
    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransanctions();
    Long deleteTransactionById(Long id);
}
