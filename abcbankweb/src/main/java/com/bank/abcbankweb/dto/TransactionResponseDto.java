package com.bank.abcbankweb.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TransactionResponseDto {

    private Long transactionId;
    private LocalDate dateOfTransaction;
    private String transactionType;
    private Double transactionedAmount;
    private Double closingBalance;
}

