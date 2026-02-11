package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.TransactionDTO;
import com.bank.abcbankweb.response.ApiResponse;

public interface TransactionService {

    ApiResponse saveTransaction(TransactionDTO dto);

    ApiResponse getAllTransactions();

    ApiResponse getByAccountNumber(Long accountNumber);
}