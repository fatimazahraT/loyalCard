package com.example.app.Repository;

import com.example.app.Models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromotionRepository  extends JpaRepository<Promotion,Long> {
   Optional<Promotion> findByMerchantCode(String Merchant_code);
}
