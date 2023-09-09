package com.example.app.Service;

import com.example.app.Models.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();

    Card getCardById(Long cardId);

    Card saveCard(Card card);

    void deleteCardById(Long cardId);

    Card updateCard(Long cardId, Card updatedCard);

    Card createCard(Card card);
}
