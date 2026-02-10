package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.entity.DebitCardType;
import com.bank.abcbankweb.repository.DebitCardTypeRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.DebitCardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DebitCardTypeServiceImpl
        implements DebitCardTypeService {

    private final DebitCardTypeRepository debitCardTypeRepository;

    @Override
    public ApiResponse getAllDebitCardTypes() {

        List<DebitCardType> list =
                debitCardTypeRepository.findAll();

        return new ApiResponse(
                "Debit Card Types Fetched Successfully",
                list
        );
    }

    @Override
    public ApiResponse getDebitCardTypeById(Integer id) {

        DebitCardType type =
                debitCardTypeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Debit Card Type Not Found"));

        return new ApiResponse(
                "Debit Card Type Found",
                type
        );
    }
}