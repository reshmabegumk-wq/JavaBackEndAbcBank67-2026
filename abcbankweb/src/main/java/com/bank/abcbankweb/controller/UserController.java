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

    private final UserService service;

    @PostMapping("/save")
    public ApiResponse save(
            @Valid @RequestBody UserDTO dto) {
        return service.saveUser(dto);
    }

    @GetMapping("/getAll")
    public ApiResponse getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/getById{id}")
    public ApiResponse getById(
            @PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public ApiResponse update(
            @PathVariable Integer id,
            @Valid @RequestBody UserDTO dto) {
        return service.updateUser(id, dto);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginDTO dto) {
        return service.login(dto);
    }
}