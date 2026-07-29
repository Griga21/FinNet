package com.service.bankaccountservice;

import com.entity.BankAccount;
import com.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public Long createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountBalance(new BigDecimal(0));
        bankAccount.setAccountNumber(UUID.randomUUID().toString());
        bankAccountRepository.save(bankAccount);
        return bankAccount.getId();
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).get();
    }

    @Override
    public List<BankAccount> getAllBankAccount() {
        return bankAccountRepository.findAll();
    }

    @Override
    @Transactional
    public Long deleteBankAccountById(Long id) {
        bankAccountRepository.deleteById(id);
        return id;
    }
}
