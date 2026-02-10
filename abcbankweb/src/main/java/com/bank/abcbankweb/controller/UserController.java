package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.LoginDTO;
import com.bank.abcbankweb.dto.UserDTO;
import com.bank.abcbankweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO dto) {
        return userService.saveUser(dto);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

//    @PostMapping("/login")
//    public String login(@RequestBody LoginDTO dto) {
//        userService.login(dto.getUserName(), dto.getPassword());
//        return "Login successful";
//    }

    @PostMapping("/login")
    public LoginDTO login(@RequestBody LoginDTO dto) {
        return userService.login(dto.getEmail(), dto.getPassword());
    }


//    @GetMapping("/loginById/{id}")
//    public UserDTO loginById(@PathVariable Integer id) {
//        return userService.getUserById(id);
//    }
}
