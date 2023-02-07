package com.rewardprogram.demo.domain.dto;

import com.rewardprogram.demo.domain.Transaction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TransactionDTO {
    private int id;
    private String date;
    private int amount;
    private int rewards;
    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.date = transaction.getDate();
        this.amount = transaction.getAmount();
        this.rewards = transaction.getRewards();
    }
}
