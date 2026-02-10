package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @NotBlank(message = "Transaction type cannot be null")
    @Column(name = "transaction_type",
            length = 10,
            nullable = false)
    private String transactionType;

    @NotNull(message = "Amount cannot be null")
    @Column(name = "amount",
            nullable = false)
    private double amount;

    @NotNull(message = "Balance after transaction cannot be null")
    @Column(name = "balance_after_transaction")
    private double balanceAfterTransaction;

    @NotNull(message = "Transaction date cannot be null")
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(
            name = "account_number",
            referencedColumnName = "account_number"
    )
    private Account account;
}