package com.bank.customerperson.usecase.customer;

import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.entity.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PaginateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public PaginateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Page<Customer> execute(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return customerGateway.findAllExcludingDeleted(pageable);
    }

}
