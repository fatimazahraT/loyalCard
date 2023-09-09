package com.example.app.Service;

import com.example.app.Models.Promotion;
import com.example.app.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImp implements PromotionService{
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImp(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion getPromotionById(Long promotionId) {
        return promotionRepository.findById(promotionId)
                .orElseThrow(() -> new IllegalArgumentException("Promotion not found with ID: " + promotionId));
    }

    @Override
    public Promotion updatePromotion(Long promotionId, Promotion updatedPromotion) {
        Promotion existingPromotion = getPromotionById(promotionId);
        existingPromotion.setPromotionName(updatedPromotion.getPromotionName());
        existingPromotion.setPromotionDescription(updatedPromotion.getPromotionDescription());
        existingPromotion.setStartDate(updatedPromotion.getStartDate());
        existingPromotion.setEndDate(updatedPromotion.getEndDate());
        existingPromotion.setDiscountAmount(updatedPromotion.getDiscountAmount());
        existingPromotion.setPromotionPercentage(updatedPromotion.getPromotionPercentage());
        existingPromotion.setPromotionCode(updatedPromotion.getPromotionCode());
        existingPromotion.setMinQuantity(updatedPromotion.getMinQuantity());
        existingPromotion.setMaxQuantity(updatedPromotion.getMaxQuantity());
        existingPromotion.setMinPrice(updatedPromotion.getMinPrice());
        existingPromotion.setMaxPrice(updatedPromotion.getMaxPrice());
        existingPromotion.setIsActive(updatedPromotion.getIsActive());
        existingPromotion.setValidForMembership(updatedPromotion.getValidForMembership());
        existingPromotion.setValidForNewCustomers(updatedPromotion.getValidForNewCustomers());
        existingPromotion.setValidForExistingCustomers(updatedPromotion.getValidForExistingCustomers());
        return promotionRepository.save(existingPromotion);
    }

    @Override
    public void deletePromotion(Long promotionId) {
        promotionRepository.deleteById(promotionId);
    }
}
