package com.example.app.Controler;

import com.example.app.Models.Merchant;
import com.example.app.Service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/{merchantId}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable Long merchantId) {
        Merchant merchant = merchantService.getMerchantById(merchantId);
        return ResponseEntity.ok(merchant);
    }

    @GetMapping
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> merchants = merchantService.getAllMerchants();
        return ResponseEntity.ok(merchants);
    }

    @PostMapping
    public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant) {
        Merchant createdMerchant = merchantService.createMerchant(merchant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMerchant);
    }

    @PutMapping("/{merchantId}")
    public ResponseEntity<Merchant> updateMerchant(@PathVariable Long merchantId, @RequestBody Merchant updatedMerchant) {
        Merchant merchant = merchantService.updateMerchant(merchantId, updatedMerchant);
        return ResponseEntity.ok(merchant);
    }

    @DeleteMapping("/{merchantId}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable Long merchantId) {
        merchantService.deleteMerchant(merchantId);
        return ResponseEntity.noContent().build();
    }
}

