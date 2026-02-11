package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.TransactionDTO;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveTransaction(
            @RequestBody TransactionDTO transactionDTO) {
        ApiResponse response = transactionService.saveTransaction(transactionDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllTransactions() {
        ApiResponse response = transactionService.getAllTransactions();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<ApiResponse> getTransactionsByAccountNumber(
            @PathVariable Long accountNumber) {
        ApiResponse response = transactionService.getByAccountNumber(accountNumber);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}