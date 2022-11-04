package com.joseneyra.sfmsbrewery.services.impl;

import com.joseneyra.sfmsbrewery.services.CustomerService;
import com.joseneyra.sfmsbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().
                id(id).
                name("Jose").
                build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // Todo
    }

    @Override
    public void deleteByCustomerById(UUID customerId) {
        // Todo
    }
}
