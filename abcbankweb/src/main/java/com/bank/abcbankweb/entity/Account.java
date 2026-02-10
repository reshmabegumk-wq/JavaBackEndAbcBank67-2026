package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    private String accountType;

    private double balance;

    private double averageBalance;

    private Integer approvedBy;

    private LocalDate openedDate;

    // 🔗 Proper relationship mapping
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;

    // ===== Getters and Setters =====

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAverageBalance() {
        return averageBalance;
    }

    public void setAverageBalance(double averageBalance) {
        this.averageBalance = averageBalance;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LocalDate getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(LocalDate openedDate) {
        this.openedDate = openedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
