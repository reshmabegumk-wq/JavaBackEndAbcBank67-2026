package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "card")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @NotNull(message = "Card number cannot be null")
    @Column(name = "card_number", nullable = false, unique = true)
    private Long cardNumber;

    @NotNull(message = "Current limit cannot be null")
    @Column(name = "current_limit", nullable = false)
    private Double currentLimit;

    @NotNull(message = "Issued date cannot be null")
    @Column(name = "issued_date", nullable = false)
    private LocalDate issuedDate;

    @NotNull(message = "Expiry date cannot be null")
    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @NotNull(message = "Status cannot be null")
    @Size(max = 15)
    @Column(name = "status", nullable = false, length = 15)
    private String status;

    @NotNull(message = "CVV number cannot be null")
    @Size(max = 3)
    @Column(name = "cvv_number", nullable = false, length = 3)
    private String cvvNumber;

    @NotNull(message = "Max limit cannot be null")
    @Column(name = "max_limit", nullable = false)
    private Double maxLimit;

    @ManyToOne
    @JoinColumn(name = "card_type_id", nullable = false)
    private CardType cardType;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;

}