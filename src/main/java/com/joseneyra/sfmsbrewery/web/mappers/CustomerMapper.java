package com.joseneyra.sfmsbrewery.web.mappers;

import com.joseneyra.sfmsbrewery.domain.Customer;
import com.joseneyra.sfmsbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto (Customer customer);

    Customer customerDtoToCustomer (CustomerDto customerDto);
}
