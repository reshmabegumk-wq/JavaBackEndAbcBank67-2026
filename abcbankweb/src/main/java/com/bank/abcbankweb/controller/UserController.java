package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.LoginRequestDto;
import com.bank.abcbankweb.dto.LoginResponseDto;
import com.bank.abcbankweb.dto.UserRequestDto;
import com.bank.abcbankweb.dto.UserResponseDto;
import com.bank.abcbankweb.entity.User;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.LoginService;
import com.bank.abcbankweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<User>> saveUser(
            @RequestBody UserRequestDto request) {
        return ResponseEntity.ok(userService.createUserWithAccount(request));
    }


    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(
            @PathVariable Long userId) {

        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ApiResponse<Void>> updateUser(
            @PathVariable Long userId,
            @RequestBody UserRequestDto request) {
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(
            @RequestBody LoginRequestDto request) {

        return ResponseEntity.ok(loginService.login(request));
    }


}


