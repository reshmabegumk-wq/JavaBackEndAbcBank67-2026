package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService
            transactionService;

    @GetMapping("/getAll")
    public ApiResponse getAllTransactions() {
        return transactionService
                .getAllTransactions();
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(
            @PathVariable Long id) {

        return transactionService
                .getTransactionById(id);
    }

    @GetMapping("/account/{accountNumber}")
    public ApiResponse
    getByAccountNumber(
            @PathVariable Long accountNumber) {

        return transactionService
                .getTransactionsByAccountNumber(
                        accountNumber);
    }
}