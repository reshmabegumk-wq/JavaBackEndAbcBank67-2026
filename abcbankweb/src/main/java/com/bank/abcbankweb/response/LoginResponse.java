package com.bank.abcbankweb.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String message;
    private Integer roleId;
    private String status;
}