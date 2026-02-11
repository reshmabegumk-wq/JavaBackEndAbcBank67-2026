package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.CardDTO;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CardController {

    private final CardService cardService;

    @PostMapping("/save")
    public ApiResponse saveCard(@Valid @RequestBody CardDTO cardDTO) {
        return cardService.saveCard(cardDTO);
    }

    @GetMapping("/getAll")
    public ApiResponse getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/account/{accountNumber}")
    public ApiResponse getCardsByAccountNumber(@PathVariable Long accountNumber) {
        return cardService.getCardsByAccountNumber(accountNumber);
    }
}