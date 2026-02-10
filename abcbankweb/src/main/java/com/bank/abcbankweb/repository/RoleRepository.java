package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByRoleName(@NotBlank @Size(max = 50) String roleName);
}