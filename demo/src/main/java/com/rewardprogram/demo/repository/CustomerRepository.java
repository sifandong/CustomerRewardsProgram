package com.rewardprogram.demo.repository;

import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
