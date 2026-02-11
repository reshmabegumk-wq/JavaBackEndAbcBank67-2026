package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.AccountResponseDto;
import com.bank.abcbankweb.response.ApiResponse;

import java.util.List;

public interface AccountService {

    ApiResponse<List<AccountResponseDto>> getAccountsByUserId(Long userId);
}