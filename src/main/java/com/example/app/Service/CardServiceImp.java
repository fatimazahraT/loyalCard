package com.example.app.Service;

import com.example.app.Models.Card;
import com.example.app.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImp implements CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImp(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).get();
    }

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCardById(Long cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    public Card updateCard(Long cardId, Card updatedCard) {
        Optional<Card> existingCardOptional = cardRepository.findById(cardId);
        if (existingCardOptional.isPresent()) {
            Card existingCard = existingCardOptional.get();
            existingCard.setCardNumber(updatedCard.getCardNumber());
            existingCard.setCardholderName(updatedCard.getCardholderName());
            existingCard.setCardExpiryDate(updatedCard.getCardExpiryDate());
            existingCard.setCardType(updatedCard.getCardType());
            existingCard.setCardStatus(updatedCard.getCardStatus());
            existingCard.setAcquirerReferenceNumber(updatedCard.getAcquirerReferenceNumber());
            existingCard.setInternalReferenceNumber(updatedCard.getInternalReferenceNumber());
            existingCard.setCaptureInterface(updatedCard.getCaptureInterface());
            existingCard.setRoutingInterface(updatedCard.getRoutingInterface());
            existingCard.setStanData(updatedCard.getStanData());
            existingCard.setBankCode(updatedCard.getBankCode());
            existingCard.setBranchCode(updatedCard.getBranchCode());
            existingCard.setBusinessDate(updatedCard.getBusinessDate());
            existingCard.setProcessingCode(updatedCard.getProcessingCode());
            existingCard.setAuthorizationAmount(updatedCard.getAuthorizationAmount());
            existingCard.setAuthorizationCurrency(updatedCard.getAuthorizationCurrency());
            existingCard.setBillingAmount(updatedCard.getBillingAmount());
            existingCard.setBillingCurrency(updatedCard.getBillingCurrency());
            existingCard.setTerminalNumber(updatedCard.getTerminalNumber());
            existingCard.setTerminalAcronym(updatedCard.getTerminalAcronym());
            existingCard.setActionCode(updatedCard.getActionCode());
            existingCard.setAuthorizationDate(updatedCard.getAuthorizationDate());
            existingCard.setAuthorizationCode(updatedCard.getAuthorizationCode());
            existingCard.setLocalDate(updatedCard.getLocalDate());
            existingCard.setAuthoFlag(updatedCard.getAuthoFlag());
            existingCard.setChipFlag(updatedCard.getChipFlag());
            existingCard.setMatchingStatus(updatedCard.getMatchingStatus());
            existingCard.setMatchingDate(updatedCard.getMatchingDate());

            return cardRepository.save(existingCard);
        } else {
            throw new IllegalArgumentException("Card not found with ID: " + cardId);
        }
    }

    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

}
