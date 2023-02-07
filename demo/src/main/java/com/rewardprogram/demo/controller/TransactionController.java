package com.rewardprogram.demo.controller;

import com.rewardprogram.demo.domain.dto.TransactionDTO;
import com.rewardprogram.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
public class TransactionController {
    private TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(int id) {
        return new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK);

    }

    @PostMapping("/transactions")
    public void createTransaction(@RequestBody TransactionDTO transactionDTO){

    }
    @DeleteMapping("/transactions/{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionService.deleteTransactionById(id);
    }


}
