package com.example.app.Repository;

import com.example.app.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository  extends JpaRepository<Card,Long> {
     Optional<Card> findByCardNumber(String cardNumber);
     Optional<Card> findByUserId(Long userId);
}
