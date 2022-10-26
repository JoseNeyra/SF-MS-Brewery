package com.joseneyra.sfmsbrewery.services.impl;

import com.joseneyra.sfmsbrewery.services.CustomerService;
import com.joseneyra.sfmsbrewery.web.model.CustomerDataTransferObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDataTransferObject getCustomerById(UUID id) {
        return CustomerDataTransferObject.builder().
                id(id).
                name("Jose").
                build();
    }

    @Override
    public CustomerDataTransferObject saveNewCustomer(CustomerDataTransferObject customerDto) {
        return CustomerDataTransferObject.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDataTransferObject customerDto) {
        // Todo
    }

    @Override
    public void deleteByCustomerById(UUID customerId) {
        // Todo
    }
}
