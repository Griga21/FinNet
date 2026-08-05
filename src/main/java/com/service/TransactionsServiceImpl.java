package com.service;

import com.dto.CreateTransactionRequest;
import com.entity.BankAccount;
import com.entity.Transaction;
import com.repository.BankAccountRepository;
import com.repository.TransactionRepository;
import com.service.bankOperations.TransactionValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

import static com.entity.TransactionStatus.PENDING;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionValidationService transactionValidationService;

    @Override
    @Transactional
    public Long createTransaction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setStatus(PENDING);
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setCreatedAt(Instant.now());
        BankAccount fromAccount = bankAccountRepository
                .findById(request.getFromAccountId()).get();

        BankAccount toAccount = bankAccountRepository
                .findById(request.getToAccountId()).get();
        transactionValidationService.checkTransferEligibility(fromAccount, toAccount, request.getAmount());
        transaction.setBankAccountFrom(fromAccount);
        transaction.setBankAccountTo(toAccount);
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
