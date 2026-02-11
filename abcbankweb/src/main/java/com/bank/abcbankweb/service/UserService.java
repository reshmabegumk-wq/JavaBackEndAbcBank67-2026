package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.UserRequestDto;
import com.bank.abcbankweb.dto.UserResponseDto;
import com.bank.abcbankweb.entity.User;
import com.bank.abcbankweb.response.ApiResponse;

public interface UserService {

    ApiResponse<User> createUserWithAccount(UserRequestDto request);


    ApiResponse<UserResponseDto> getUserById(Long userId);

    ApiResponse<Void> updateUser(Long userId, UserRequestDto request);
}
