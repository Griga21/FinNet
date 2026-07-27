package com.service;

import java.util.UUID;

public interface TransactionService {
    Long createTransaction();
    Long deleteTransactionById(Long id);
}
