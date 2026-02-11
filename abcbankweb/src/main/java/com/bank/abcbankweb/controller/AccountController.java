package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.AccountDTO;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public ApiResponse createAccount(
            @Valid @RequestBody AccountDTO dto
    ) {
        return accountService.createAccount(dto);
    }

    @GetMapping("/getAll")
    public ApiResponse getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/get/{accountNumber}")
    public ApiResponse getByAccountNumber(
            @PathVariable Long accountNumber
    ) {
        return accountService.getAccountByNumber(accountNumber);
    }
}