package com.bank.abcbankweb.repository;

import com.bank.abcbankweb.entity.ChequeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChequeRequestRepository extends JpaRepository<ChequeRequest, Integer> {

    List<ChequeRequest> findByAccount_AccountNumberOrderByChequeRequestIdDesc(Long accountNumber);
}