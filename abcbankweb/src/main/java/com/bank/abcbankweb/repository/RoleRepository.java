package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository
        extends JpaRepository<Role, Integer> {
}