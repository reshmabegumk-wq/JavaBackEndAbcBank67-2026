package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "user_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;

    @NotBlank(message = "Mobile number is required")
    @Column(name = "mobile_number", length = 12, nullable = false, unique = true)
    private String mobileNumber;

    @Column(name = "alternative_number", length = 12)
    private String alternativeNumber;

    @NotBlank(message = "Email is required")
    @Column(name = "email", length = 65, nullable = false, unique = true)
    private String email;

    @NotNull(message = "Date of birth is required")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank(message = "Address is required")
    @Column(name = "address", length = 225, nullable = false)
    private String address;

    @NotBlank(message = "City is required")
    @Column(name = "city", length = 30, nullable = false)
    private String city;

    @NotBlank(message = "State is required")
    @Column(name = "state", length = 25, nullable = false)
    private String state;

    @NotBlank(message = "Country is required")
    @Column(name = "country", length = 45, nullable = false)
    private String country;

    @NotBlank(message = "Pincode is required")
    @Column(name = "pincode", length = 6, nullable = false)
    private String pincode;

    @NotBlank(message = "PAN card is required")
    @Column(name = "pan_card", length = 14, nullable = false, unique = true)
    private String panCard;

    @NotBlank(message = "Aadhar number is required")
    @Column(name = "aadhar_number", length = 12, nullable = false, unique = true)
    private String aadhar;

    @NotBlank(message = "Username is required")
    @Column(name = "user_name", length = 35, nullable = false, unique = true)
    private String userName;

    @NotBlank(message = "Password is required")
    @Column(name = "password", length = 120, nullable = false)
    private String password;

    @NotNull(message = "Role is required")
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}