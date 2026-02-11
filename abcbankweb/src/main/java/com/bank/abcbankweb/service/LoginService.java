package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.LoginRequestDto;
import com.bank.abcbankweb.dto.LoginResponseDto;
import com.bank.abcbankweb.response.ApiResponse;

public interface LoginService {

    ApiResponse<LoginResponseDto> login(LoginRequestDto request);
}