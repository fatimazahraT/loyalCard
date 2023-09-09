package com.example.app.Service;

import com.example.app.Models.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    Account getAccountById(Long id);

    Account createAccount(Account account);

    Account updateAccount(String accountNumber, Account account);

    boolean deleteAccount(Long id);
}
