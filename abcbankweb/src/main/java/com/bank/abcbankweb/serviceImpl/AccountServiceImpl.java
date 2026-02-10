package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl
        implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public ApiResponse getAllAccounts() {

        List<Account> list =
                accountRepository.findAll();

        return new ApiResponse(
                "Account List Fetched",
                list
        );
    }

    @Override
    public ApiResponse getAccountById(
            Long id) {

        Account account =
                accountRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Account Not Found"));

        return new ApiResponse(
                "Account Found",
                account
        );
    }
}