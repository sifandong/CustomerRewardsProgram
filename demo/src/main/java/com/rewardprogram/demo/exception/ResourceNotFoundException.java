package com.rewardprogram.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(int id) {
        super(String.format("Transaction with Id %d not found", id));
    }
}