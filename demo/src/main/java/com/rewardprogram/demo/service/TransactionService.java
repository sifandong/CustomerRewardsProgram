package com.rewardprogram.demo.service;

import com.rewardprogram.demo.domain.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions();
    TransactionDTO getTransactionById(int id);
    int createTransaction(TransactionDTO transactionDTO);
    void deleteTransactionById(int id);

}
