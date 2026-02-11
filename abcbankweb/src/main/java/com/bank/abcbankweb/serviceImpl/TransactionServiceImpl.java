package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.TransactionDTO;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.Transaction;
import com.bank.abcbankweb.repository.TransactionRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl
        implements TransactionService {

    private final TransactionRepository repo;

    @Override
    public ApiResponse saveTransaction(
            TransactionDTO dto) {

        Transaction t = new Transaction();

        t.setDateOfTransaction(
                dto.getDateOfTransaction() != null
                        ? dto.getDateOfTransaction()
                        : LocalDate.now()
        );
        t.setClosingBalance(dto.getClosingBalance());
        t.setTransactionType(dto.getTransactionType());
        t.setTransactionedAmount(
                dto.getTransactionedAmount()
        );

        Account account = new Account();
        account.setAccountNumber(
                dto.getAccountNumber()
        );

        t.setAccount(account);

        repo.save(t);

        return new ApiResponse(
                "Transaction saved successfully",
                t
        );
    }

    @Override
    public ApiResponse getAllTransactions() {

        List<Transaction> list = repo.findAll();

        if (list.isEmpty()) {
            return new ApiResponse(
                    "No transactions found",
                    null
            );
        }

        return new ApiResponse(
                "Transactions fetched successfully",
                list
        );
    }

    @Override
    public ApiResponse getByAccountNumber(
            Long accountNumber) {

        List<Transaction> list =
                repo.findByAccount_AccountNumberOrderByTransactionIdDesc(
                        accountNumber
                );

        if (list.isEmpty()) {
            return new ApiResponse(
                    "No transactions found for this account",
                    null
            );
        }

        return new ApiResponse(
                "Transactions fetched successfully",
                list
        );
    }
}