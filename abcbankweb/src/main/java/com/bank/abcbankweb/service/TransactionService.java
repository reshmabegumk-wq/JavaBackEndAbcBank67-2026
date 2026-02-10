package com.bank.abcbankweb.service;

import com.bank.abcbankweb.response.ApiResponse;

public interface TransactionService {

    ApiResponse getAllTransactions();

    ApiResponse getTransactionById(Long id);

    ApiResponse getTransactionsByAccountNumber(
            Long accountNumber);
}