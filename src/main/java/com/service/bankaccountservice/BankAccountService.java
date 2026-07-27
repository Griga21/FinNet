package com.service.bankaccountservice;

import com.entity.BankAccount;
import com.entity.Transaction;

import java.util.List;

public interface BankAccountService {
    Long createBankAccount();
    BankAccount getBankAccountById(Long id);
    List<BankAccount> getAllBankAccount();
    Long deleteBankAccountById(Long id);
}
