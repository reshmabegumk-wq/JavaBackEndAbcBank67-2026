package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.LostCardStolenCardDTO;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.LostCardStolenCard;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.repository.LostCardStolenCardRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.LostCardStolenCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LostCardStolenCardServiceImpl implements LostCardStolenCardService {

    private final LostCardStolenCardRepository repo;
    private final AccountRepository accountRepository;

    @Override
    public ApiResponse saveLostCardRequest(LostCardStolenCardDTO dto) {

        Optional<Account> optionalAccount = accountRepository.findById(dto.getAccountNumber());

        if (optionalAccount.isEmpty()) {
            return new ApiResponse("Account not found", null);
        }

        Account account = optionalAccount.get();

        LostCardStolenCard lc = new LostCardStolenCard();
        lc.setLostCardStolenDate(dto.getLostCardStolenDate());
        lc.setLostCardNumber(dto.getLostCardNumber());
        lc.setRequestedDate(dto.getRequestedDate() != null ? dto.getRequestedDate() : LocalDate.now());
        lc.setApprovedDate(dto.getApprovedDate());
        lc.setApprovedBy(dto.getApprovedBy());
        lc.setResponse(dto.getResponse());
        lc.setStatus(dto.getStatus() != null && !dto.getStatus().isBlank() ? dto.getStatus() : "PENDING");
        lc.setAccount(account);

        repo.save(lc);

        return new ApiResponse("Lost/stolen card request saved successfully with status: " + lc.getStatus(), lc);
    }

    @Override
    public ApiResponse getAllLostCardRequests() {

        List<LostCardStolenCard> list = repo.findAll();

        if (list.isEmpty()) {
            return new ApiResponse("No lost/stolen card requests found", null);
        }

        return new ApiResponse("Lost/stolen card requests fetched successfully", list);
    }

    @Override
    public ApiResponse getByAccountNumber(Long accountNumber) {

        List<LostCardStolenCard> list = repo.findByAccount_AccountNumberOrderByLostCardRequestIdDesc(accountNumber);

        if (list.isEmpty()) {
            return new ApiResponse("No lost/stolen card requests found for this account", null);
        }

        return new ApiResponse("Lost/stolen card requests fetched successfully", list);
    }
}