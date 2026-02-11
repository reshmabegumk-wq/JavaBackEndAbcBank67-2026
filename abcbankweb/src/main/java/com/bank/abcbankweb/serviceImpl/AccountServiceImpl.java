package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.AccountDTO;
import com.bank.abcbankweb.dto.AccountResponseDto;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.AccountType;
import com.bank.abcbankweb.entity.User;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public ApiResponse<List<AccountResponseDto>> getAccountsByUserId(Long userId) {

        List<Account> accounts = accountRepository.findByCustomerUserId(userId);

        List<AccountResponseDto> response = accounts.stream().map(acc -> {
            AccountResponseDto dto = new AccountResponseDto();
            dto.setAccountNumber(acc.getAccountNumber());
            dto.setBalance(acc.getBalance());
            dto.setBranchName(acc.getBranchName());
            dto.setBranchCode(acc.getBranchCode());
            dto.setCity(acc.getCity());
            dto.setState(acc.getState());
            dto.setStatus(acc.getStatus());
            return dto;
        }).toList();

        return new ApiResponse<>(
                true,
                "Accounts Fetched Successfully",
                response
        );
    }
}