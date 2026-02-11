package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @NotNull(message = "Date of transaction is required")
    @Column(name = "date_of_transaction", nullable = false)
    private LocalDate dateOfTransaction;

    @NotNull(message = "Closing balance is required")
    @Column(name = "closing_balance", nullable = false)
    private Double closingBalance;

    @NotBlank(message = "Transaction type is required")
    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @NotNull(message = "Transaction amount is required")
    @Column(name = "transactioned_amount", nullable = false)
    private Double transactionedAmount;

    @NotNull(message = "Account is required")
    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;
}