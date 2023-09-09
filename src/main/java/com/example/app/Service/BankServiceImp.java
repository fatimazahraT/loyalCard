package com.example.app.Service;

import com.example.app.Models.Bank;
import com.example.app.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImp implements BankService{
        private final BankRepository bankRepository;

        @Autowired
        public BankServiceImp(BankRepository bankRepository) {
            this.bankRepository = bankRepository;
        }

        @Override
        public List<Bank> getAllBanks() {
            return bankRepository.findAll();
        }

        @Override
        public Bank getBankByCode(String bankCode) {
            Optional<Bank> optionalBank = bankRepository.findById(bankCode);
            return optionalBank.orElse(null);
        }

        @Override
        public Bank createBank(Bank bank) {
            return bankRepository.save(bank);
        }

        @Override
        public Bank updateBank(String bankCode, Bank bank) {
            Optional<Bank> optionalBank = bankRepository.findById(bankCode);
            if (optionalBank.isPresent()) {
                Bank existingBank = optionalBank.get();
                existingBank.setWording(bank.getWording());
                existingBank.setCurrencyCode(bank.getCurrencyCode());
                existingBank.setTvaRate(bank.getTvaRate());
                existingBank.setAddress(bank.getAddress());
                existingBank.setCountryCode(bank.getCountryCode());
                existingBank.setZipCode(bank.getZipCode());
                existingBank.setCityCode(bank.getCityCode());
                return bankRepository.save(existingBank);
            } else {
                return null; // or throw an exception
            }
        }

        @Override
        public void deleteBank(String bankCode) {
            bankRepository.deleteById(bankCode);
        }
}
