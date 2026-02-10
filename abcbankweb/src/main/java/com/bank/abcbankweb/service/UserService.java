package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.LoginDTO;
import com.bank.abcbankweb.dto.UserDTO;

import java.util.List;

public interface UserService {

    String saveUser(UserDTO dto);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Integer id);

    LoginDTO login(String userName, String password);
}