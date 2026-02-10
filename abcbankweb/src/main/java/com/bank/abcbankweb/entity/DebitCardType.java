package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "debit_card_type")
public class DebitCardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "debit_card_type_id")
    private Integer debitCardTypeId;

    @NotBlank(message = "Debit card type name cannot be null")
    @Column(name = "debit_card_type_name", length = 30, nullable = false, unique = true)
    private String debitCardTypeName;
}
