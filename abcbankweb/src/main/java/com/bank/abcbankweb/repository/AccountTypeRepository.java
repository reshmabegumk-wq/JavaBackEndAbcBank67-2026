package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}