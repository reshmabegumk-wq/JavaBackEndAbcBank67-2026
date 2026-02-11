package com.bank.abcbankweb.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ChequeRequestDTO {

    private Integer chequeRequestId;
    private Integer noOfLeaves;
    private LocalDate requestedDate;
    private LocalDate approvedDate;
    private Integer approvedBy;
    private String status;
    private String response;
    private Long accountNumber;
}