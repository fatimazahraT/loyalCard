package com.example.app.Controler;
import com.example.app.Models.Promotion;
import com.example.app.Service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/{promotionId}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable Long promotionId) {
        Promotion promotion = promotionService.getPromotionById(promotionId);
        return ResponseEntity.ok(promotion);
    }

    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion createdPromotion = promotionService.createPromotion(promotion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPromotion);
    }

    @PutMapping("/{promotionId}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long promotionId, @RequestBody Promotion updatedPromotion) {
        Promotion promotion = promotionService.updatePromotion(promotionId, updatedPromotion);
        return ResponseEntity.ok(promotion);
    }

    @DeleteMapping("/{promotionId}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Long promotionId) {
        promotionService.deletePromotion(promotionId);
        return ResponseEntity.noContent().build();
    }
}

