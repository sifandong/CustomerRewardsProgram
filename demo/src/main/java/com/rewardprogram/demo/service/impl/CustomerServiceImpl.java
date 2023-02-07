package com.rewardprogram.demo.service.impl;

import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.domain.Transaction;
import com.rewardprogram.demo.domain.dto.CustomerDTO;
import com.rewardprogram.demo.exception.ResourceNotFoundException;
import com.rewardprogram.demo.repository.CustomerRepository;
import com.rewardprogram.demo.repository.TransactionRepository;
import com.rewardprogram.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepo;
    private final TransactionRepository transactionRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepo, TransactionRepository transactionRepo) {
        this.customerRepo = customerRepo;
        this.transactionRepo = transactionRepo;
    }
    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> list = customerRepo.findAll();
        return list.stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());

    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new CustomerDTO(customer);
    }

    @Override
    public int createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        return customerRepo.save(customer).getId();
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public int getRewardsBetweenStartDateAndEndDate(int id, Date startDate, Date endDate) {
        List<Transaction> list = transactionRepo.findByDateCreatedBetween(startDate, endDate);
        return list
                .stream()
                .filter(t -> t.getCustomer().getId() == id)
                .mapToInt(Transaction::getRewards)
                .sum();
    }


}
