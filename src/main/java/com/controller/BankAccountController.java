package com.controller;

import com.dto.BankAccountResponse;
import com.dto.CreateBankAccountRequest;
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
    public void createBankAccount(@RequestBody CreateBankAccountRequest сreateBankAccountRequest) {
        BankAccountResponse id = bankAccountService.createBankAccount(сreateBankAccountRequest);
        System.out.println(id);
    }

    @GetMapping("/get")
    public BankAccountResponse getBankAccountById(@RequestParam("id") Long id) {
        return bankAccountService.getBankAccountById(id);
    }

    @GetMapping("/getAll")
    public List<BankAccountResponse> getAllBankAccount() {
        return bankAccountService.getAllBankAccount();
    }

    @DeleteMapping("/deleteById")
    public void deleteBankAccountById(@RequestParam("id") Long id) {
        bankAccountService.deleteBankAccountById(id);
    }

}
