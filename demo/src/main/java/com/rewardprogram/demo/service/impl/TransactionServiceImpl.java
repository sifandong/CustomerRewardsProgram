package com.rewardprogram.demo.service.impl;

import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.domain.Transaction;
import com.rewardprogram.demo.domain.dto.TransactionDTO;
import com.rewardprogram.demo.exception.CustomerNotFoundException;
import com.rewardprogram.demo.exception.TransactionNotFoundException;
import com.rewardprogram.demo.repository.CustomerRepository;
import com.rewardprogram.demo.repository.TransactionRepository;
import com.rewardprogram.demo.service.TransactionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepo;
    private CustomerRepository customerRepo;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepo, CustomerRepository customerRepo) {
        this.transactionRepo = transactionRepo;
        this.customerRepo = customerRepo;
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
    public void createTransaction(TransactionDTO transactionDTO) throws CustomerNotFoundException {
        Customer customer = customerRepo.findById(transactionDTO.getCustomerId())
                .orElseThrow(() -> new TransactionNotFoundException(transactionDTO.getCustomerId()));
        Transaction transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setDate(transactionDTO.getDate());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setRewards(calculateRewards(transactionDTO.getAmount()));
        transactionRepo.save(transaction);

    }

    @Override
    public void deleteTransactionById(int id) {
        transactionRepo.deleteById(id);
    }

    private int calculateRewards(int amount) {
        int res = 0;
        if (amount < 50) {
            return res;
        } else if (amount < 100) {
            return amount - 50;
        } else {
            return 2*(amount-100) + 50;
        }
    }

}
