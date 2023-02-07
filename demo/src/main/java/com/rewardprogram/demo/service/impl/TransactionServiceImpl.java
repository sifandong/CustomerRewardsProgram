package com.rewardprogram.demo.service.impl;

import com.rewardprogram.demo.domain.Transaction;
import com.rewardprogram.demo.domain.dto.TransactionDTO;
import com.rewardprogram.demo.exception.TransactionNotFoundException;
import com.rewardprogram.demo.repository.TransactionRepository;
import com.rewardprogram.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepo;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> list = transactionRepo.findAll();
        return list.stream()
                .map(TransactionDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getTransactionById(int id) {
        Transaction transaction = transactionRepo.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
        return new TransactionDTO(transaction);
    }

    @Override
    public void createTransaction(TransactionDTO transactionDTO) {

    }

    @Override
    public void deleteTransactionById(int id) {
        transactionRepo.deleteById(id);
    }

}
