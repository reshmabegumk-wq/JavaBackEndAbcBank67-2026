package com.bank.abcbankweb.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardDTO {

    @NotNull(message = "Card number cannot be null")
    private Long cardNumber;

    @NotNull(message = "Current limit cannot be null")
    private Double currentLimit;

    @NotNull(message = "Issued date cannot be null")
    private LocalDate issuedDate;

    @NotNull(message = "Expiry date cannot be null")
    private LocalDate expiryDate;

    @NotNull(message = "Status cannot be null")
    @Size(max = 45)
    private String status;

    @NotNull(message = "CVV cannot be null")
    @Size(max = 3)
    private String cvvNumber;

    @NotNull(message = "Max limit cannot be null")
    private Double maxLimit;

    @NotNull(message = "Card type id cannot be null")
    private Integer cardTypeId;

    @NotNull(message = "Account number cannot be null")
    private Long accountNumber;

}