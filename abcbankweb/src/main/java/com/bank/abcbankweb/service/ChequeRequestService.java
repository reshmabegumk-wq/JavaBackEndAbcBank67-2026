package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.ChequeRequestDTO;
import com.bank.abcbankweb.response.ApiResponse;

public interface ChequeRequestService {

    ApiResponse saveChequeRequest(ChequeRequestDTO dto);

    ApiResponse getAllChequeRequests();

    ApiResponse getByAccountNumber(Long accountNumber);
}