package com.service.bankOperations;

import com.entity.Transaction;

import java.util.List;

public interface AccountHistoryService {
    List<Transaction> getAccountTransactionById(Long accountId);
}
