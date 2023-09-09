package com.example.app.Service;



import com.example.app.Models.Transaction;

import java.util.List;

public interface TransactionService {

    // Method to create a new transaction
    Transaction createTransaction(Transaction transaction);

    // Method to update an existing transaction


    // Method to retrieve a transaction by its ID
    Transaction getTransactionById(Long id);

    // Method to delete a transaction by its ID
    boolean deleteTransaction(Long id);

    List<Transaction> getAllTransactions();

    // Other methods (if needed)

}
