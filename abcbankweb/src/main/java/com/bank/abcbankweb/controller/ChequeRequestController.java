package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.ChequeRequestDTO;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.ChequeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cheque-requests")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ChequeRequestController {

    private final ChequeRequestService service;

    @PostMapping("/save")
    public ApiResponse saveChequeRequest(@RequestBody ChequeRequestDTO dto) {
        return service.saveChequeRequest(dto);
    }

    @GetMapping("/getAll")
    public ApiResponse getAllChequeRequests() {
        return service.getAllChequeRequests();
    }

    @GetMapping("/account/{accountNumber}")
    public ApiResponse getByAccountNumber(@PathVariable Long accountNumber) {
        return service.getByAccountNumber(accountNumber);
    }
}