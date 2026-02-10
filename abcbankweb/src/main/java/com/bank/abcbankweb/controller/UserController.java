package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.LoginDTO;
import com.bank.abcbankweb.dto.UserDTO;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.response.LoginResponse;
import com.bank.abcbankweb.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ApiResponse saveUser(
            @Valid @RequestBody UserDTO dto) {

        return userService.saveUser(dto);
    }

    @GetMapping("/getAll")
    public ApiResponse getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getUserById(
            @PathVariable Integer id) {

        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateUser(
            @PathVariable Integer id,
            @RequestBody UserDTO dto) {

        return userService.updateUser(id, dto);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginDTO dto) {

        return userService.login(
                dto.getEmail(),
                dto.getPassword());
    }
}