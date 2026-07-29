package com.mapper;

import com.dto.BankAccountDTO;
import com.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankDeviceMapper implements BankAccountMapperI{

    public BankAccountDTO fromBankAccountToDto(BankAccount bankAccount){
        BankAccountDTO bankAccountDTO = new BankAccountDTO(bankAccount.getId());
        bankAccountDTO.setAccountBalance(bankAccount.getAccountBalance());
        bankAccountDTO.setAccountNumber(bankAccount.getAccountNumber());
        return bankAccountDTO;
    }

    public List<BankAccountDTO> fromListBankAccountToDto(List<BankAccount> bankAccountList){
        List<BankAccountDTO> bankAccountDTOList = new ArrayList<>();
        for (BankAccount bankAccount: bankAccountList){
            BankAccountDTO bankAccountDTO = fromBankAccountToDto(bankAccount);
            bankAccountDTOList.add(bankAccountDTO);
        }
        return bankAccountDTOList;
    }

    public BankAccount fromDtoToBankAccount(BankAccountDTO bankAccountDTO){

        return null;
    }
}
