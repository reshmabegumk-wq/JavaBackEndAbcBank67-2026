package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "cheque_request")
@Data
public class ChequeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cheque_request_id")
    private Integer chequeRequestId;

    @NotNull(message = "Number of leaves is required")
    @Positive(message = "Number of leaves must be positive")
    @Column(name = "no_of_leaves", nullable = false)
    private Integer noOfLeaves;

    @NotNull(message = "Requested date is required")
    @Column(name = "requested_date", nullable = false)
    private LocalDate requestedDate;

    @Column(name = "approved_date")
    private LocalDate approvedDate;

    @Column(name = "approved_by")
    private Integer approvedBy;

    @NotBlank(message = "Status is required")
    @Column(name = "status", length = 10, nullable = false)
    private String status = "PENDING";

    @Column(name = "response", length = 255)
    private String response;

    @NotNull(message = "Account is required")
    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;
}