package com.bank.abcbankweb.dto;

import lombok.Data;

@Data
public class LoginDTO {

    private String email;
    private String password;
    private String fullName;
}