package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.*;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.AccountType;
import com.bank.abcbankweb.entity.Role;
import com.bank.abcbankweb.entity.User;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.repository.AccountTypeRepository;
import com.bank.abcbankweb.repository.RoleRepository;
import com.bank.abcbankweb.repository.UserRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.response.LoginResponse;
import com.bank.abcbankweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AccountTypeRepository accountTypeRepository;

    @Transactional
    public ApiResponse<User> createUserWithAccount(UserRequestDto request) {

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMobileNumber(request.getMobileNumber());
        user.setEmail(request.getEmail());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());
        user.setState(request.getState());
        user.setCountry(request.getCountry());
        user.setPincode(request.getPincode());
        user.setPancard(request.getPancard());
        user.setAadhar(request.getAadhar());
        user.setPassword("abcbank@123");
        user.setRole(role);

        user.setCreatedBy(1L);
        user.setCreatedDate(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        AccountType accountType = accountTypeRepository.findById(request.getAccountTypeId())
                .orElseThrow(() -> new RuntimeException("Account Type not found"));

        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(request.getInitialBalance());
        account.setOpenedDate(LocalDate.now());
        account.setStatus("Active");
        account.setBranchName(request.getBranchName());
        account.setBranchCode(request.getBranchCode());
        account.setCity(request.getCity());
        account.setState(request.getState());
        account.setAccountType(accountType);
        account.setCustomer(savedUser);

        accountRepository.save(account);

        return new ApiResponse<>(
                true,
                "User Saved Successfully",null
        );
    }

    private Long generateAccountNumber() {
        return 1000000000L + new Random().nextInt(900000000);
    }


    public ApiResponse<UserResponseDto> getUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Account> accounts = accountRepository.findByCustomerUserId(userId);

        UserResponseDto response = new UserResponseDto();
        response.setUserId(user.getUserId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setMobileNumber(user.getMobileNumber());
        response.setCity(user.getCity());
        response.setState(user.getState());
        response.setRoleName(user.getRole().getRoleName());

        List<AccountResponseDto> accountDtos = accounts.stream().map(acc -> {
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

        response.setAccounts(accountDtos);

        return new ApiResponse<>(
                true,
                "User Fetched Successfully",
                response
        );
    }


    @Transactional
    public ApiResponse<Void> updateUser(Long userId, UserRequestDto request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMobileNumber(request.getMobileNumber());
        user.setEmail(request.getEmail());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());
        user.setState(request.getState());
        user.setCountry(request.getCountry());
        user.setPincode(request.getPincode());
        user.setPancard(request.getPancard());
        user.setAadhar(request.getAadhar());
        user.setUpdatedBy(1L);
        user.setUpdatedDate(LocalDateTime.now());

        userRepository.save(user);
        return new ApiResponse<>(
                true,
                "User Updated Successfully",
                null
        );
    }
}

