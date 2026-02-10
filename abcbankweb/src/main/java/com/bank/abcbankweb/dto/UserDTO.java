package com.bank.abcbankweb.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Data
public class UserDTO {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String alternateMobileNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String country;
    private String aadharNumber;
    private String panNumber;
    private LocalDate dateOfBirth;
    private String userName;
    private String password;

    private Integer roleId;

}