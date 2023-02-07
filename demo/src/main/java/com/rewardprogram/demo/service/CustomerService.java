package com.rewardprogram.demo.service;

import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.domain.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(int id);
    void createCustomer(CustomerDTO customerDTO);
    void deleteCustomerById(int id);
    int getRewardsBetweenStartDateAndEndDate(int id, String startDate, String endDate);

}
