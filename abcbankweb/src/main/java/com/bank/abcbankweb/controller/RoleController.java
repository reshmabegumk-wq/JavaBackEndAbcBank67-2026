package com.bank.abcbankweb.controller;

import com.bank.abcbankweb.dto.RoleDto;
import com.bank.abcbankweb.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/save")
    public RoleDto createRole(@Valid @RequestBody RoleDto dto) {
        return roleService.saveRole(dto);
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable Integer id) {
        return roleService.getRoleById(id);
    }
    @GetMapping("/all")
    public Iterable<RoleDto> getAllRoles() {
        // This method is not implemented in RoleService, but you can add it similarly to getAllUsers in UserService.
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
