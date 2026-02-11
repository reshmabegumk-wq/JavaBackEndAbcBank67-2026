package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.TransactionDTO;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.Transaction;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.repository.TransactionRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repo;
    private final AccountRepository accountRepository;

    @Override
    public ApiResponse saveTransaction(TransactionDTO dto) {

        Optional<Account> optionalAccount = accountRepository.findById(dto.getAccountNumber());

        if (optionalAccount.isEmpty()) {
            return new ApiResponse("Account not found", null);
        }

        Account account = optionalAccount.get();
        double currentBalance = account.getBalance();
        double amount = dto.getTransactionedAmount();
        double closingBalance;

        if (dto.getTransactionType().equalsIgnoreCase("CREDIT")) {
            closingBalance = currentBalance + amount;
        } else if (dto.getTransactionType().equalsIgnoreCase("DEBIT")) {
            if (currentBalance < amount) {
                return new ApiResponse("Insufficient balance", null);
            }
            closingBalance = currentBalance - amount;
        } else {
            return new ApiResponse("Invalid transaction type", null);
        }

        Transaction t = new Transaction();
        t.setDateOfTransaction(dto.getDateOfTransaction() != null ? dto.getDateOfTransaction() : LocalDate.now());
        t.setTransactionType(dto.getTransactionType());
        t.setTransactionedAmount(amount);
        t.setClosingBalance(closingBalance);
        t.setAccount(account);

        repo.save(t);

        account.setBalance(closingBalance);
        accountRepository.save(account);

        return new ApiResponse("Transaction saved successfully", t);
    }

    @Override
    public ApiResponse getAllTransactions() {
        List<Transaction> list = repo.findAll();
        if (list.isEmpty()) {
            return new ApiResponse("No transactions found", null);
        }
        return new ApiResponse("Transactions fetched successfully", list);
    }

    @Override
    public ApiResponse getByAccountNumber(Long accountNumber) {
        List<Transaction> list = repo.findByAccount_AccountNumberOrderByTransactionIdDesc(accountNumber);
        if (list.isEmpty()) {
            return new ApiResponse("No transactions found for this account", null);
        }
        return new ApiResponse("Transactions fetched successfully", list);
    }
}