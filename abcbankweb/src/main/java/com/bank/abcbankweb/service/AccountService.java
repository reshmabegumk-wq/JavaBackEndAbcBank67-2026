package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.AccountDTO;
import com.bank.abcbankweb.response.ApiResponse;

public interface AccountService {

    ApiResponse createAccount(AccountDTO accountDTO);

    ApiResponse getAllAccounts();

    ApiResponse getAccountByNumber(Long accountNumber);

}