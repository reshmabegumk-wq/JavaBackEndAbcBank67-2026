package com.bank.abcbankweb.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {

    @NotNull(message = "Date of transaction is required")
    private LocalDate dateOfTransaction;

    @NotNull(message = "Closing balance is required")
    @PositiveOrZero(message = "Closing balance must be zero or positive")
    private Double closingBalance;

    @NotBlank(message = "Transaction type is required")
    private String transactionType;

    @NotNull(message = "Transaction amount is required")
    @Positive(message = "Transaction amount must be positive")
    private Double transactionedAmount;

    @NotNull(message = "Account number is required")
    private Long accountNumber;
}