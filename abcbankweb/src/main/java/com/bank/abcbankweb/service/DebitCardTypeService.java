package com.bank.abcbankweb.service;

import com.bank.abcbankweb.response.ApiResponse;

public interface DebitCardTypeService {

    ApiResponse getAllDebitCardTypes();

    ApiResponse getDebitCardTypeById(Integer id);
}