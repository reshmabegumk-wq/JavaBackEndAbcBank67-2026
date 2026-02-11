package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.LoginRequestDto;
import com.bank.abcbankweb.dto.LoginResponseDto;
import com.bank.abcbankweb.entity.User;
import com.bank.abcbankweb.repository.UserRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public ApiResponse<LoginResponseDto> login(LoginRequestDto request) {

        User user = userRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElse(null);

        if (user == null) {
            return new ApiResponse<>(
                    false,
                    "Invalid Email or Password",
                    null
            );
        }

        LoginResponseDto response = new LoginResponseDto(
                "Login Successful",
                user.getRole().getRoleId(),
                "Active"
        );

        return new ApiResponse<>(
                true,
                "Login Success",
                response
        );
    }
}