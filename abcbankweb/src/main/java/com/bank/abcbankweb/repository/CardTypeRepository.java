package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTypeRepository
        extends JpaRepository<CardType, Integer> {
}