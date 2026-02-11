package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.ChequeRequestDTO;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.ChequeRequest;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.repository.ChequeRequestRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.ChequeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChequeRequestServiceImpl implements ChequeRequestService {

    private final ChequeRequestRepository repo;
    private final AccountRepository accountRepository;

    @Override
    public ApiResponse saveChequeRequest(ChequeRequestDTO dto) {

        Optional<Account> optionalAccount = accountRepository.findById(dto.getAccountNumber());

        if (optionalAccount.isEmpty()) {
            return new ApiResponse("Account not found", null);
        }

        Account account = optionalAccount.get();

        ChequeRequest cr = new ChequeRequest();
        cr.setNoOfLeaves(dto.getNoOfLeaves());
        cr.setRequestedDate(dto.getRequestedDate() != null ? dto.getRequestedDate() : LocalDate.now());
        cr.setApprovedDate(dto.getApprovedDate());
        cr.setApprovedBy(dto.getApprovedBy());
        cr.setResponse(dto.getResponse());
        cr.setAccount(account);

        // Default status to PENDING if not provided
        cr.setStatus(dto.getStatus() != null && !dto.getStatus().isBlank() ? dto.getStatus() : "PENDING");

        repo.save(cr);

        return new ApiResponse("Cheque request saved successfully with status: " + cr.getStatus(), cr);
    }

    @Override
    public ApiResponse getAllChequeRequests() {

        List<ChequeRequest> list = repo.findAll();

        if (list.isEmpty()) {
            return new ApiResponse("No cheque requests found", null);
        }

        return new ApiResponse("Cheque requests fetched successfully", list);
    }

    @Override
    public ApiResponse getByAccountNumber(Long accountNumber) {

        List<ChequeRequest> list = repo.findByAccount_AccountNumberOrderByChequeRequestIdDesc(accountNumber);

        if (list.isEmpty()) {
            return new ApiResponse("No cheque requests found for this account", null);
        }

        return new ApiResponse("Cheque requests fetched successfully", list);
    }
}