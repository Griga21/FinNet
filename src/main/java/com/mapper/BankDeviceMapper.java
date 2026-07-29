package com.mapper;

import com.dto.BankAccountDTO;
import com.entity.BankAccount;

public class BankDeviceMapper {

    public BankAccountDTO fromBankAccountToDto(BankAccount bankAccount){
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setAccountBalance(bankAccount.getAccountBalance());
        bankAccountDTO.setAccountNumber(bankAccount.getAccountNumber());
        return bankAccountDTO;
    }

    public BankAccount fromDtoToBankAccount(BankAccountDTO bankAccountDTO){

        return null;
    }
}
