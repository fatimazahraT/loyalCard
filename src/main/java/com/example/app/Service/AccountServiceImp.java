package com.example.app.Service;

import com.example.app.Models.Account;
import com.example.app.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(String accountNumber, Account updatedAccount) {
        Account existingAccount = accountRepository.findByAccountNumber(accountNumber);

        if (existingAccount != null) {
            // Update all properties from updatedAccount to existingAccount
            existingAccount.setEntity(updatedAccount.getEntity());
            existingAccount.setBankCode(updatedAccount.getBankCode());
            existingAccount.setBranchCode(updatedAccount.getBranchCode());
            existingAccount.setUserId(updatedAccount.getUserId());
            existingAccount.setProgramIndex(updatedAccount.getProgramIndex());
            existingAccount.setProgramRedemption(updatedAccount.getProgramRedemption());
            existingAccount.setBalanceTrxPreviousMonth(updatedAccount.getBalanceTrxPreviousMonth());
            existingAccount.setBalancePointsCurrentMonth(updatedAccount.getBalancePointsCurrentMonth());
            existingAccount.setBalancePointsPreviousMonth(updatedAccount.getBalancePointsPreviousMonth());
            existingAccount.setBalanceTrxCurrentMonth(updatedAccount.getBalanceTrxCurrentMonth());
            existingAccount.setRedeemedPoints(updatedAccount.getRedeemedPoints());
            // ... update all other properties

            return accountRepository.save(existingAccount);
        }

        return null; // or throw an exception if needed
    }

    @Override
    public boolean deleteAccount(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.delete(account.get());
            return true;
        }
        return false; // Account with the given id not found
    }
}
