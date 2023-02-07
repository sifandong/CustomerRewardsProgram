package com.rewardprogram.demo.service;

import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.domain.dto.CustomerDTO;

import java.util.Date;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(int id);
    int createCustomer(CustomerDTO customerDTO);
    void deleteCustomerById(int id);
    int getRewardsBetweenStartDateAndEndDate(int id, Date startDate, Date endDate);

}
