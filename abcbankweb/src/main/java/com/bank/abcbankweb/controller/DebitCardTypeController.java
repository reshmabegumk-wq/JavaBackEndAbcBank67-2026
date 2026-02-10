package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.DebitCardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/debit-card-types")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DebitCardTypeController {

    private final DebitCardTypeService debitCardTypeService;

    @GetMapping("/getAll")
    public ApiResponse getAllDebitCardTypes() {
        return debitCardTypeService.getAllDebitCardTypes();
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(
            @PathVariable Integer id) {

        return debitCardTypeService
                .getDebitCardTypeById(id);
    }
}