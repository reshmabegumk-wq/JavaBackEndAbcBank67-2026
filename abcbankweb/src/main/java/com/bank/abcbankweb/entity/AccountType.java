package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_type_id")
    private Integer accountTypeId;

    @Column(name = "account_type_name", length = 45)
    private String accountTypeName;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;
}
