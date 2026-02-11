package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.AccountResponseDto;
import com.bank.abcbankweb.dto.TransactionResponseDto;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.AccountService;
import com.bank.abcbankweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions/{accountNumber}")
    public ResponseEntity<ApiResponse<List<TransactionResponseDto>>>
    getTransactions(@PathVariable Long accountNumber) {

        return ResponseEntity.ok(
                transactionService.getTransactionsByAccountNumber(accountNumber)
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<List<AccountResponseDto>>> getAccountsByUserId(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                accountService.getAccountsByUserId(userId)
        );
    }

}

