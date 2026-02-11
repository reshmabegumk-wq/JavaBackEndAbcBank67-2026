package com.bank.abcbankweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {

    private String message;
    private Integer roleId;
    private String status;
}
