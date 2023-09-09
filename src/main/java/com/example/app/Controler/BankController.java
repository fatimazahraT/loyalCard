package com.example.app.Controler;

import com.example.app.Models.Bank;
import com.example.app.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
@CrossOrigin(origins = "*")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    // Endpoint for retrieving all banks
    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> banks = bankService.getAllBanks();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }

    // Endpoint for retrieving a bank by bank code
    @GetMapping("/{bankCode}")
    public ResponseEntity<Bank> getBankByCode(@PathVariable String bankCode) {
        Bank bank = bankService.getBankByCode(bankCode);
        if (bank != null) {
            return new ResponseEntity<>(bank, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint for creating a new bank
    @PostMapping("/create")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank createdBank = bankService.createBank(bank);
        return new ResponseEntity<>(createdBank, HttpStatus.CREATED);
    }

    // Endpoint for updating an existing bank
    @PutMapping("/{bankCode}")
    public ResponseEntity<Bank> updateBank(@PathVariable String bankCode, @RequestBody Bank bank) {
        Bank updatedBank = bankService.updateBank(bankCode, bank);
        if (updatedBank != null) {
            return new ResponseEntity<>(updatedBank, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint for deleting a bank by bank code
    @DeleteMapping("/{bankCode}")
    public ResponseEntity<Void> deleteBank(@PathVariable String bankCode) {
        bankService.deleteBank(bankCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
