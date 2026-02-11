package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "opened_date")
    private LocalDate openedDate;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "branch_name", length = 45)
    private String branchName;

    @Column(name = "branch_code", length = 25)
    private String branchCode;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "state", length = 45)
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private User customer;
}
