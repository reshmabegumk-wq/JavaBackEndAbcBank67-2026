package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/getAll")
    public ApiResponse getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(
            @PathVariable Long id) {

        return accountService
                .getAccountById(id);
    }
}