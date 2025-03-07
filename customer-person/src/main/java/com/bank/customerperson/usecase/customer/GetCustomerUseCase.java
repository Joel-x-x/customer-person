package com.bank.customerperson.usecase.customer;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.entity.customer.model.Customer;

import java.util.UUID;

public class GetCustomerUseCase {
    private final CustomerGateway customerGateway;

    public GetCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(UUID id) throws CustomerNotFoundException {
        return this.customerGateway
                .findById(id)
                .orElseThrow(CustomerNotFoundException::new);
    }
}
