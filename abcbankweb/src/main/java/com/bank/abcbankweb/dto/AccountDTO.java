package com.bank.abcbankweb.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountDTO {

    @NotNull(message = "Account number is required")
    private Long accountNumber;

    @NotNull(message = "Balance cannot be null")
    @PositiveOrZero(message = "Balance must be zero or positive")
    private Double balance;

    @NotNull(message = "Opened date is required")
    private LocalDate openedDate;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Branch name is required")
    private String branchName;

    @NotBlank(message = "Branch code is required")
    private String branchCode;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotNull(message = "Account type ID is required")
    private Integer accountTypeId;

    @NotNull(message = "Customer ID is required")
    private Integer customerId;
}