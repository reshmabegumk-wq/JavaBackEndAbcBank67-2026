package com.bank.abcbankweb.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Long transactionId;

    private String transactionType;

    private double amount;

    private double balanceAfterTransaction;

    private LocalDateTime transactionDate;

    private Long accountNumber;
}