package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.LostCardStolenCardDTO;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.LostCardStolenCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lost-card-requests")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LostCardStolenCardController {

    private final LostCardStolenCardService service;

    @PostMapping("/save")
    public ApiResponse saveLostCardRequest(@RequestBody LostCardStolenCardDTO dto) {
        return service.saveLostCardRequest(dto);
    }

    @GetMapping("/getAll")
    public ApiResponse getAllLostCardRequests() {
        return service.getAllLostCardRequests();
    }

    @GetMapping("/account/{accountNumber}")
    public ApiResponse getByAccountNumber(@PathVariable Long accountNumber) {
        return service.getByAccountNumber(accountNumber);
    }
}