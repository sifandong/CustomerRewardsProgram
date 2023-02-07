package com.rewardprogram.demo.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(int id) {
        super(String.format("Transaction with Id %d not found", id));
    }
}