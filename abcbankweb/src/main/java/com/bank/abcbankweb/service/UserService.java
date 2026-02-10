package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.UserDTO;

import java.util.List;

public interface UserService {

    String saveUser(UserDTO dto);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Integer id);

    UserDTO login(String userName, String password);
}