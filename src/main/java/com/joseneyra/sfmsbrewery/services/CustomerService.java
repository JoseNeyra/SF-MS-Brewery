package com.joseneyra.sfmsbrewery.services;

import com.joseneyra.sfmsbrewery.web.model.CustomerDataTransferObject;

import java.util.UUID;

public interface CustomerService {

    public CustomerDataTransferObject getCustomerById(UUID id);

    public CustomerDataTransferObject saveNewCustomer(CustomerDataTransferObject customerDto);

    public void updateCustomer(UUID customerId, CustomerDataTransferObject customerDto);

    public void deleteByCustomerById(UUID customerId);
}
