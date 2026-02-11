package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.CardDTO;
import com.bank.abcbankweb.response.ApiResponse;
import java.util.List;

public interface CardService {
    ApiResponse saveCard(CardDTO cardDTO);
    ApiResponse getAllCards();
    ApiResponse getCardsByAccountNumber(Long accountNumber);
}