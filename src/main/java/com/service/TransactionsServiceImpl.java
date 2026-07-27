package com.service;

import com.entity.Transaction;
import com.entity.TransactionType;
import com.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public Long createTransaction() {
        Transaction transaction = new Transaction();
        transaction.setAccountId(UUID.randomUUID());
        transaction.setAmount(new BigDecimal(1000));
        transaction.setType(TransactionType.WITHDRAWAL);
        transaction.setCreatedAt(Instant.now());
        transactionRepository.save(transaction);
        return transaction.getId();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public List<Transaction> getAllTransanctions() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional
    public Long deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
        return id;
    }
}
