package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "account_type")
@Data
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "account_type_id",
            nullable = false)
    private Integer accountTypeId;

    @NotBlank
    @Column(
            name = "account_type_name",
            length = 15,
            nullable = false,
            unique = true)
    private String accountTypeName;
}