package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.DebitCardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitCardTypeRepository
        extends JpaRepository<DebitCardType, Integer> {
}