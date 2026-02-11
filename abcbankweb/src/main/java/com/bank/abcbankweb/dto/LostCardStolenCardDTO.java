package com.bank.abcbankweb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LostCardStolenCardDTO {

    private Integer lostCardRequestId;
    private LocalDate lostCardStolenDate;
    private Long lostCardNumber;
    private LocalDate requestedDate;
    private LocalDate approvedDate;
    private Integer approvedBy;
    private String status;
    private String response;
    private Long accountNumber;
}