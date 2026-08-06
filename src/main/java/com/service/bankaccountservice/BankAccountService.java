package com.service.bankaccountservice;

import com.dto.BankAccountResponse;
import com.dto.CreateBankAccountRequest;
import com.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccountResponse createBankAccount(CreateBankAccountRequest сreateBankAccountRequest);
    BankAccountResponse getBankAccountResponseById(Long id);
    BankAccount getBankAccountById(Long id);
    List<BankAccountResponse> getAllBankAccount();
    Long deleteBankAccountById(Long id);
}
