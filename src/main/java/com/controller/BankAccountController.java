package com.controller;

import com.dto.BankAccountDTO;
import com.entity.BankAccount;
import com.entity.Transaction;
import com.service.TransactionService;
import com.service.bankaccountservice.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankAccount")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @PostMapping("/create")
    public void createBankAccount(){
        Long id = bankAccountService.createBankAccount();
        System.out.println(id);
    }

    @GetMapping("/get")
    public BankAccountDTO getBankAccountById(@RequestParam("id") Long id){
        return bankAccountService.getBankAccountById(id);
    }

    @GetMapping("/getAll")
    public List<BankAccountDTO> getAllBankAccount(){
        return bankAccountService.getAllBankAccount();
    }

    @DeleteMapping("/deleteById")
    public void deleteBankAccountById(@RequestParam("id") Long id) {
        bankAccountService.deleteBankAccountById(id);
    }

}
