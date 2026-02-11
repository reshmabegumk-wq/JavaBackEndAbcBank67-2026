package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "account")
@Data
public class Account {

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @NotNull(message = "Balance cannot be null")
    @PositiveOrZero(message = "Balance must be zero or positive")
    @Column(name = "balance", nullable = false)
    private Double balance;

    @NotNull(message = "Account opened date is required")
    @Column(name = "opened_date", nullable = false)
    private LocalDate openedDate;

    @NotBlank(message = "Account status is required")
    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @NotBlank(message = "Branch name is required")
    @Column(name = "branch_name", length = 45, nullable = false)
    private String branchName;

    @NotBlank(message = "Branch code is required")
    @Column(name = "branch_code", length = 25, nullable = false)
    private String branchCode;

    @NotBlank(message = "City is required")
    @Column(name = "city", length = 45, nullable = false)
    private String city;

    @NotBlank(message = "State is required")
    @Column(name = "state", length = 45, nullable = false)
    private String state;

    @NotNull(message = "Account type is required")
    @ManyToOne
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;

    @NotNull(message = "Customer is required")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User user;
}