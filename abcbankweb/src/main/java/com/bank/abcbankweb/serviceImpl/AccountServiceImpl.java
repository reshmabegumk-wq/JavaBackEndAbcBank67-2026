package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.AccountDTO;
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

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public ApiResponse createAccount(AccountDTO dto) {

        if (accountRepository.existsById(dto.getAccountNumber())) {
            return new ApiResponse("Account number already exists", null);
        }

        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setBalance(dto.getBalance());
        account.setOpenedDate(dto.getOpenedDate() != null ? dto.getOpenedDate() : LocalDate.now());
        account.setStatus(dto.getStatus());
        account.setBranchName(dto.getBranchName());
        account.setBranchCode(dto.getBranchCode());
        account.setCity(dto.getCity());
        account.setState(dto.getState());

        AccountType accountType = new AccountType();
        accountType.setAccountTypeId(dto.getAccountTypeId());
        account.setAccountType(accountType);

        User user = new User();
        user.setUserId(dto.getCustomerId());
        account.setUser(user);

        accountRepository.save(account);

        return new ApiResponse("Account created successfully", account);
    }

    @Override
    public ApiResponse getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();

        if (accounts.isEmpty()) {
            return new ApiResponse("No accounts found", null);
        }

        return new ApiResponse("Accounts fetched successfully", accounts);
    }

    @Override
    public ApiResponse getAccountByNumber(Long accountNumber) {

        Optional<Account> optional = accountRepository.findById(accountNumber);

        if (optional.isEmpty()) {
            return new ApiResponse("Account not found", null);
        }

        return new ApiResponse("Account fetched successfully", optional.get());
    }
}