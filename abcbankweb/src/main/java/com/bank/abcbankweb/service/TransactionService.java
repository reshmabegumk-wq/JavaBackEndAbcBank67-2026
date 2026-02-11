package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.TransactionResponseDto;
import com.bank.abcbankweb.response.ApiResponse;

import java.util.List;

public interface TransactionService {

    ApiResponse<List<TransactionResponseDto>> getTransactionsByAccountNumber(Long accountNumber);
}
