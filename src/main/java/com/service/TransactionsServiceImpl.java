package com.service;

import com.dto.BankAccountResponse;
import com.dto.CreateBankAccountRequest;
import com.dto.CreateTransactionRequest;
import com.entity.BankAccount;
import com.entity.Transaction;
import com.entity.TransactionType;
import com.mapper.BankAccountMapper;
import com.repository.BankAccountRepository;
import com.repository.TransactionRepository;
import com.service.bankaccountservice.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;
    @Override
    @Transactional
    public Long createTransaction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setCreatedAt(Instant.now());
        BankAccount fromAccount = bankAccountRepository
                .findById(request.getFromAccountId()).get();

        BankAccount toAccount = bankAccountRepository
                .findById(request.getToAccountId()).get();
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
