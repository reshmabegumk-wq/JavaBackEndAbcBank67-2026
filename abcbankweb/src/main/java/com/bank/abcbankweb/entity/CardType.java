package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "card_type")
@Data
public class CardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "card_type_id",
            nullable = false)
    private Integer cardTypeId;

    @NotBlank
    @Column(
            name = "card_type_name",
            length = 10,
            nullable = false,
            unique = true)
    private String cardTypeName;
}