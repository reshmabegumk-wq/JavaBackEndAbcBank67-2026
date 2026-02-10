package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.entity.Transaction;
import com.bank.abcbankweb.repository.TransactionRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl
        implements TransactionService {

    private final TransactionRepository
            transactionRepository;

    @Override
    public ApiResponse getAllTransactions() {

        List<Transaction> list =
                transactionRepository.findAll();

        return new ApiResponse(
                "Transaction List Fetched",
                list
        );
    }

    @Override
    public ApiResponse getTransactionById(
            Long id) {

        Transaction txn =
                transactionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Transaction Not Found"));

        return new ApiResponse(
                "Transaction Found",
                txn
        );
    }

    @Override
    public ApiResponse
    getTransactionsByAccountNumber(
            Long accountNumber) {

        List<Transaction> list =
                transactionRepository
                        .findByAccount_AccountNumber(
                                accountNumber);

        if (list.isEmpty()) {
            throw new RuntimeException(
                    "No Transactions Found For This Account");
        }

        return new ApiResponse(
                "Account Wise Transactions Fetched",
                list
        );
    }
}