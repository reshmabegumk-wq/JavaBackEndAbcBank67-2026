package com.bank.abcbankweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "user_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @NotBlank(message = "Mobile number is required")
    @Column(name = "mobile_number", length = 15, nullable = false)
    private String mobileNumber;

    @Column(name = "alternate_mobile_number", length = 15)
    private String alternateMobileNumber;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @NotBlank(message = "Address is required")
    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @NotBlank(message = "City is required")
    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @NotBlank(message = "State is required")
    @Column(name = "state", length = 50, nullable = false)
    private String state;

    @NotBlank(message = "Pincode is required")
    @Column(name = "pincode", length = 6, nullable = false)
    private String pinCode;

    @NotBlank(message = "Country is required")
    @Column(name = "country", length = 50, nullable = false)
    private String country;

    @NotBlank(message = "Aadhar number is required")
    @Column(name = "aadhar_number", length = 12, nullable = false, unique = true)
    private String aadharNumber;

    @NotBlank(message = "PAN number is required")
    @Column(name = "pan_number", length = 10, nullable = false, unique = true)
    private String panNumber;

    @NotNull(message = "Date of birth is required")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank(message = "Username is required")
    @Column(name = "user_name", length = 50, nullable = false, unique = true)
    private String userName;

    @NotBlank(message = "Password is required")
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}