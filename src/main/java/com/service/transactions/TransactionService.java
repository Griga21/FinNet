package com.service.transactions;

import com.dto.CreateTransactionRequest;
import com.entity.BankAccount;
import com.entity.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    Long createTransaction(CreateTransactionRequest request);
    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransanctions();
    Long deleteTransactionById(Long id);
    List<Transaction> getAllTransationFromAccountByID(Long accountId);
}
