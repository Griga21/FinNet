package com.service.bankaccountservice;

import com.dto.BankAccountDTO;
import com.entity.BankAccount;
import com.entity.Transaction;

import java.util.List;

public interface BankAccountService {
    Long createBankAccount();
    BankAccountDTO getBankAccountById(Long id);
    List<BankAccountDTO> getAllBankAccount();
    Long deleteBankAccountById(Long id);
}
