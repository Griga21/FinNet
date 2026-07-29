package com.service.bankaccountservice;

import com.dto.BankAccountDTO;
import com.entity.BankAccount;
import com.mapper.BankAccountMapperI;
import com.mapper.BankDeviceMapper;
import com.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    private final BankAccountMapperI bankDeviceMapper;

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
    public BankAccountDTO getBankAccountById(Long id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        BankAccountDTO bankAccountDTO = bankDeviceMapper.fromBankAccountToDto(bankAccount);
        return bankAccountDTO;
    }

    @Override
    public List<BankAccountDTO> getAllBankAccount() {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        List<BankAccountDTO> bankAccountDTOList = bankDeviceMapper.fromListBankAccountToDto(bankAccountList);
        return bankAccountDTOList;
    }

    @Override
    @Transactional
    public Long deleteBankAccountById(Long id) {
        bankAccountRepository.deleteById(id);
        return id;
    }
}
