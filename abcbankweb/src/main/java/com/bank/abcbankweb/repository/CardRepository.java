package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByAccount_AccountNumber(Long accountNumber);
}