package com.bank.abcbankweb.service;

import com.bank.abcbankweb.response.ApiResponse;

public interface AccountService {

    ApiResponse getAllAccounts();

    ApiResponse getAccountById(Long id);
}
