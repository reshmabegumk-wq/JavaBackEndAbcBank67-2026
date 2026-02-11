package com.bank.abcbankweb.serviceImpl;

import com.bank.abcbankweb.dto.CardDTO;
import com.bank.abcbankweb.entity.Account;
import com.bank.abcbankweb.entity.Card;
import com.bank.abcbankweb.entity.CardType;
import com.bank.abcbankweb.repository.AccountRepository;
import com.bank.abcbankweb.repository.CardRepository;
import com.bank.abcbankweb.repository.CardTypeRepository;
import com.bank.abcbankweb.response.ApiResponse;
import com.bank.abcbankweb.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final CardTypeRepository cardTypeRepository;

    @Override
    public ApiResponse saveCard(CardDTO cardDTO) {
        Account account = accountRepository.findById(cardDTO.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        CardType cardType = cardTypeRepository.findById(cardDTO.getCardTypeId())
                .orElseThrow(() -> new RuntimeException("Card type not found"));
        Card card = new Card();
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCurrentLimit(cardDTO.getCurrentLimit());
        card.setIssuedDate(cardDTO.getIssuedDate());
        card.setExpiryDate(cardDTO.getExpiryDate());
        card.setStatus(cardDTO.getStatus());
        card.setCvvNumber(cardDTO.getCvvNumber());
        card.setMaxLimit(cardDTO.getMaxLimit());
        card.setAccount(account);
        card.setCardType(cardType);
        cardRepository.save(card);
        return new ApiResponse("Card saved successfully", card);
    }

    @Override
    public ApiResponse getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return new ApiResponse("All cards fetched", cards);
    }

    @Override
    public ApiResponse getCardsByAccountNumber(Long accountNumber) {
        List<Card> cards = cardRepository.findByAccount_AccountNumber(accountNumber);
        return new ApiResponse("Cards fetched for account number " + accountNumber, cards);
    }
}