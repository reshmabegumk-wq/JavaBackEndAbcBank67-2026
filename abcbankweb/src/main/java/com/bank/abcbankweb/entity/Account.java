package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private Long accountNumber;

    @NotNull(message = "Account balance cannot be null")
    @Column(name = "account_balance")
    private double accountBalance;

    @NotNull(message = "Average amount cannot be null")
    @Column(name = "average_amount")
    private double averageAmount;

    @NotNull(message = "Opened date cannot be null")
    @Column(name = "opened_date")
    private LocalDate openedDate;

    @NotBlank(message = "Account type cannot be null")
    @Column(name = "account_type")
    private String accountType;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "user_id"
    )
    private User customer;

    @ManyToOne
    @JoinColumn(
            name = "approved_by",
            referencedColumnName = "user_id"
    )
    private User approvedBy;
}