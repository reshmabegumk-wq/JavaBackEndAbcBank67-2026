package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.LoginDTO;
import com.bank.abcbankweb.dto.UserDTO;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.response.LoginResponse;

public interface UserService {

    ApiResponse saveUser(UserDTO dto);

    ApiResponse getAllUsers();

    ApiResponse getUserById(Integer id);

    ApiResponse updateUser(Integer id, UserDTO dto);

    LoginResponse login(LoginDTO dto);
}