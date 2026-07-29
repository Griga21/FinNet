package com.mapper;

import com.dto.BankAccountDTO;
import com.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BankAccountMapperI {
     BankAccountDTO fromBankAccountToDto(BankAccount bankAccount);

     List<BankAccountDTO> fromListBankAccountToDto(List<BankAccount> bankAccountList);

     BankAccount fromDtoToBankAccount(BankAccountDTO bankAccountDTO);
}
