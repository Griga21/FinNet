package com.service.bankaccountservice;

import com.dto.BankAccountResponse;
import com.dto.CreateBankAccountRequest;
import com.entity.BankAccount;
import com.exceptions.BackAccountNotFoundException;
import com.exceptions.BankAccountIsAlreadyExist;
import com.mapper.BankAccountMapper;
import com.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Override
    @Transactional
    public BankAccountResponse createBankAccount(CreateBankAccountRequest request) {
        if (bankAccountRepository.existsByAccountNumber(request.getAccountNumber())){
            throw new BankAccountIsAlreadyExist();
        }
        BankAccount bankAccount = bankAccountRepository.save(bankAccountMapper.toEntity(request));
        return bankAccountMapper.toResponse(bankAccount);
    }

    @Override
    public BankAccountResponse getBankAccountById(Long id) {
        BankAccount entity = bankAccountRepository.findById(id)
                .orElseThrow(() -> new BackAccountNotFoundException());
        return bankAccountMapper.toResponse(entity);
    }

    @Override
    public List<BankAccountResponse> getAllBankAccount() {
        List<BankAccountResponse> bankAccountDTOList = bankAccountMapper.toResponseList(bankAccountRepository.findAll());
        return bankAccountDTOList;
    }

    @Override
    @Transactional
    public Long deleteBankAccountById(Long id) {
        bankAccountRepository.deleteById(id);
        return id;
    }
}
