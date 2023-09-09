package com.example.app.Service;

import com.example.app.Models.Promotion;

public interface PromotionService {
    Promotion createPromotion(Promotion promotion);
    Promotion getPromotionById(Long promotionId);
    Promotion updatePromotion(Long promotionId, Promotion updatedPromotion);
    void deletePromotion(Long promotionId);
}
