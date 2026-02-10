package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
}
