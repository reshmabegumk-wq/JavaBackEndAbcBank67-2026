package com.bank.abcbankweb.service;

import com.bank.abcbankweb.dto.RoleDto;
import com.bank.abcbankweb.entity.Role;
import com.bank.abcbankweb.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    // ===== CREATE / SAVE ROLE =====
    public RoleDto saveRole(RoleDto dto) {

        if (roleRepository.existsByRoleName(dto.getRoleName())) {
            throw new RuntimeException("Role already exists");
        }
        Role role = new Role();
        role.setRoleName(dto.getRoleName());

        Role saved = roleRepository.save(role);
        RoleDto response = new RoleDto();
        response.setRoleId(saved.getRoleId());
        response.setRoleName(saved.getRoleName());

        return response;
    }

    // ===== GET BY ID =====
    public RoleDto getRoleById(Integer id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        RoleDto dto = new RoleDto();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());

        return dto;
    }
    public Iterable<RoleDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(role -> {
                    RoleDto dto = new RoleDto();
                    dto.setRoleId(role.getRoleId());
                    dto.setRoleName(role.getRoleName());
                    return dto;
                })
                .toList();
    }
}
