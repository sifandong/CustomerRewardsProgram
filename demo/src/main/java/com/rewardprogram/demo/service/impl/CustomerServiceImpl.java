package com.rewardprogram.demo.service.impl;

import com.rewardprogram.demo.domain.dto.CustomerDTO;
import com.rewardprogram.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        return null;
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomerById(int id) {

    }

    @Override
    public int getRewardsBetweenStartDateAndEndDate(int id, String startDate, String endDate) {
        return 0;
    }
}
