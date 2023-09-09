package com.example.app.Service;

import com.example.app.Models.Card;
import com.example.app.Models.Promotion;
import com.example.app.Models.Transaction;
import com.example.app.Models.User;
import com.example.app.Repository.CardRepository;
import com.example.app.Repository.PromotionRepository;
import com.example.app.Repository.TransactionRepository;

import com.example.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private  TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Transaction createTransaction(Transaction transaction) {
        // Retrieve the associated card using the user's ID
        Optional<Card> card = cardRepository.findByUserId(Long.valueOf(transaction.getUserId()));
        if (!card.isPresent()) {
            System.out.println("if not exist card");
            // Handle the case when the card does not exist for the user
            return null;
        }
        Optional<Promotion> promotion = promotionRepository.findByMerchantCode(card.get().getMerchant_code());
        if (promotion.isPresent() && promotion.get().getDiscountAmount() != null) {
            System.out.println("if  exist promotion");
            // Apply the promotion's discount or adjustments to the transaction
            Double discountAmount = promotion.get().getDiscountAmount();
            Double discountPercentage = promotion.get().getPromotionPercentage();

            Double transactionAmount = transaction.getTransactionAmount().doubleValue();

            // Calculate the new transaction amount after applying the promotion
            Double newTransactionAmount = transactionAmount - discountAmount;
            newTransactionAmount *= (1 - discountPercentage / 100);

            // Calculate points earned based on the new transaction amount
            Double pointsEarned = newTransactionAmount * 0.01;

            // Update the user's total points
            Optional<User> user = userRepository.findById(card.get().getUserId());
            if (user.isPresent()) {
                user.get().setTotalPoints(user.get().getTotalPoints() + pointsEarned.intValue());
                userRepository.save(user.get());
            }

            // Set the points earned in the transaction
            transaction.setPointGenerated(pointsEarned.intValue());
        } else {
            // If no promotion, convert the transaction amount to points based on conversion rate
            Double pointsEarned = transaction.getTransactionAmount().doubleValue() * 0.01;

            // Update the user's total points
            Optional<User> user = userRepository.findById(card.get().getUserId());
            if (user.isPresent()) {
                user.get().setTotalPoints(user.get().getTotalPoints() + pointsEarned.intValue());
                userRepository.save(user.get());
            }

            // Set the points earned in the transaction
            transaction.setPointGenerated(pointsEarned.intValue());
        }

        // Continue with the rest of your transaction creation logic
        // ...

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
        return false;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Other methods if needed
}
