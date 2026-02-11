package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository
        extends JpaRepository<AccountType, Integer> {
}