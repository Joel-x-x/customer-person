package com.bank.customerperson.usecase.customer;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.entity.customer.model.Customer;

import java.time.LocalDateTime;
import java.util.UUID;

public class DeleteCustomerUseCase {
    private final CustomerGateway customerGateway;

    public DeleteCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(UUID id) throws CustomerNotFoundException {
        Customer customer = customerGateway.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        customer.setDeleted(true);
        customer.setDeletedAt(LocalDateTime.now());

        this.customerGateway.update(customer);

        return customer;
    }
}
