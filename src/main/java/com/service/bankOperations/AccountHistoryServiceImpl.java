package com.service.bankOperations;

import com.entity.Transaction;
import com.entity.TransactionStatus;
import com.repository.TransactionRepository;
import com.service.transactions.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountHistoryServiceImpl implements AccountHistoryService{

    private final TransactionRepository transactionRepository;
    @Override
    public List<Transaction> getAccountTransactionById(Long accountId) {
        return transactionRepository.findAllByAccountIdAndStatus(accountId, 30);
    }
}
