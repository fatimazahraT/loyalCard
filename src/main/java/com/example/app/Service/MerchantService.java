package com.example.app.Service;

import com.example.app.Models.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant createMerchant(Merchant merchant);
    Merchant updateMerchant(Long merchantId, Merchant updatedMerchant);
    void deleteMerchant(Long merchantId);
    Merchant getMerchantById(Long merchantId);
    List<Merchant> getAllMerchants();
}
