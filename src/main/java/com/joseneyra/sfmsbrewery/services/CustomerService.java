package com.joseneyra.sfmsbrewery.services;

import com.joseneyra.sfmsbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    public CustomerDto getCustomerById(UUID id);

    public CustomerDto saveNewCustomer(CustomerDto customerDto);

    public void updateCustomer(UUID customerId, CustomerDto customerDto);

    public void deleteByCustomerById(UUID customerId);
}
