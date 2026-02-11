package com.bank.abcbankweb.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String message;
    private Integer roleId;
    private String fullName;
}



//public class LoginResponse {
//
//    private String message;
//    private Long roleId;
//    private String fullName;
//
//    public LoginResponse(String message, Long roleId, String fullName) {
//        this.message = message;
//        this.roleId = roleId;
//        this.fullName = fullName;
//    }
//
//    // getters & setters
//}
