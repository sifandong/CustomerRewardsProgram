package com.rewardprogram.demo.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(int id) {
        super(String.format("Transaction with Id %d not found", id));
    }
}
