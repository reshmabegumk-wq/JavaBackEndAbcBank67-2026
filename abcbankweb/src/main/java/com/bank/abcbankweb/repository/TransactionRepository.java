package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Integer> {

    List<Transaction>
    findByAccount_AccountNumberOrderByTransactionIdDesc(
            Long accountNumber);
}