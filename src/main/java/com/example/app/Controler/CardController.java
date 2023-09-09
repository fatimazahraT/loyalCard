package com.example.app.Controler;

import com.example.app.Models.Card;
import com.example.app.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Card> getCardById(@PathVariable Long cardId) {
        Card card = cardService.getCardById(cardId);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card createdCard = cardService.createCard(card);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestBody Card updatedCard) {
        Card card = cardService.updateCard(cardId, updatedCard);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCardById(@PathVariable Long cardId) {
        cardService.deleteCardById(cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
