package com.controller;

import com.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/create")
    public void createTransaction(){
        Long id = transactionService.createTransaction();
        System.out.println(id);
    }

    // Используем @RequestParam вместо @PathVariable
    @DeleteMapping("/deleteById")
    public void deleteTransactionById(@RequestParam("id") Long id) {
        transactionService.deleteTransactionById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }
}
