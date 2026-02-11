package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cheque_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChequeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chequeRequestId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "account_number",
            referencedColumnName = "account_number",
            nullable = false
    )
    private Account account;


    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @Column(name = "cheque_leaves_count", nullable = false)
    private Integer chequeLeavesCount;


    @ManyToOne
    @JoinColumn(
            name = "approved_by",
            referencedColumnName = "user_id"
    )
    private User approvedBy;

    @Column(name = "process_date", nullable = false)
    private LocalDateTime approvedDate;

    private String status;

    private String remarks;
}

