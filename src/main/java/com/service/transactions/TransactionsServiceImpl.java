package com.service.transactions;

import com.dto.CreateTransactionRequest;
import com.entity.BankAccount;
import com.entity.Transaction;
import com.entity.TransactionStatus;
import com.repository.TransactionRepository;
import com.service.bankOperations.TransferService;
import com.service.bankaccountservice.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final BankAccountService bankAccountService;
    private final TransactionValidationService transactionValidationService;
    private final TransferService TransferService;

    @Override
    @Transactional
    public Long createTransaction(CreateTransactionRequest request) {
        BankAccount fromAccount = bankAccountService.getBankAccountById(request.getFromAccountId());
        BankAccount toAccount = bankAccountService.getBankAccountById(request.getToAccountId());
        Transaction transaction = new Transaction();
        transaction.setStatus(TransactionStatus.PROCESSING);
        if (transactionValidationService.checkTransferEligibility(fromAccount, toAccount, request.getAmount())) {
            transaction.setStatus(TransferService.transferFunds(fromAccount, toAccount, request.getAmount()));
        } else {
            transaction.setStatus(TransactionStatus.DECLINED);
        }
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setCreatedAt(Instant.now());
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

    @Override
    public List<Transaction> getAllTransationFromAccountByID(Long accountId) {
        List<Transaction> transactionList = transactionRepository.findAllByAccountIdAndStatus(accountId, 30);
        return transactionList;
    }
}
