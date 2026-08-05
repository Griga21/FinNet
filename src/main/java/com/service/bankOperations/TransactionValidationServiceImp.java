package com.service.bankOperations;

import com.dto.BankAccountResponse;
import com.entity.AccountStatus;
import com.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionValidationServiceImp implements TransactionValidationService {
    @Override
    public boolean checkTransferEligibility(BankAccount bankAccountFrom, BankAccount bankAccountTo, BigDecimal amount) {
        if(!bankAccountFrom.getStatus().equals(AccountStatus.ACTIVE) || !bankAccountTo.getStatus().equals(AccountStatus.ACTIVE)){
            return false;
        }
        if (bankAccountFrom.getAccountBalance().compareTo(amount) < 0){
            return false;
        }
        return true;
    }
}
