package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "lost_card_stolen_card")
@Data
public class LostCardStolenCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lost_card_request_id")
    private Integer lostCardRequestId;

    @NotNull(message = "Lost/stolen card date is required")
    @Column(name = "lost_card_stolen_date", nullable = false)
    private LocalDate lostCardStolenDate;

    @Column(name = "lost_card_number")
    private Long lostCardNumber;

    @NotNull(message = "Requested date is required")
    @Column(name = "requested_date", nullable = false)
    private LocalDate requestedDate;

    @Column(name = "approved_date")
    private LocalDate approvedDate;

    @Column(name = "approved_by")
    private Integer approvedBy;

    @NotBlank
    @Column(name = "status", length = 10, nullable = false)
    private String status = "PENDING";

    @Column(name = "response", length = 255)
    private String response;

    @NotNull(message = "Account is required")
    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;
}