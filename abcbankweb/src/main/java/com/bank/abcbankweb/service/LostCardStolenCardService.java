package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.LostCardStolenCardDTO;
import com.bank.abcbankweb.response.ApiResponse;

public interface LostCardStolenCardService {

    ApiResponse saveLostCardRequest(LostCardStolenCardDTO dto);

    ApiResponse getAllLostCardRequests();

    ApiResponse getByAccountNumber(Long accountNumber);
}