package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @NotBlank(message = "Role name is required")
    @Column(name = "role_name", length = 15, nullable = false)
    private String roleName;
}