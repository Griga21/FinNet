package com.service;

import com.entity.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    Long createTransaction();
    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransanctions();
    Long deleteTransactionById(Long id);
}
