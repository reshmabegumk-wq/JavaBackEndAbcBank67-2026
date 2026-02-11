package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.LostCardStolenCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostCardStolenCardRepository extends JpaRepository<LostCardStolenCard, Integer> {

    List<LostCardStolenCard> findByAccount_AccountNumberOrderByLostCardRequestIdDesc(Long accountNumber);
}