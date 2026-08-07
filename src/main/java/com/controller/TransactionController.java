package com.controller;

import com.dto.CreateTransactionRequest;
import com.entity.Transaction;
import com.service.transactions.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/create")
    public void createTransaction(@RequestBody CreateTransactionRequest request){
        Long id = transactionService.createTransaction(request);
        System.out.println(id);
    }

    @GetMapping("/get")
    public Transaction getTransactionById(@RequestParam("id") Long id){
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/getAll")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransanctions();
    }

    @DeleteMapping("/deleteById")
    public void deleteTransactionById(@RequestParam("id") Long id) {
        transactionService.deleteTransactionById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }
}
