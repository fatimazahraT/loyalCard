package com.example.app.Service;

import com.example.app.Models.Bank;

import java.util.List;

public interface BankService {
    List<Bank> getAllBanks();

    Bank getBankByCode(String bankCode);

    Bank createBank(Bank bank);

    Bank updateBank(String bankCode, Bank bank);

    void deleteBank(String bankCode);
}
