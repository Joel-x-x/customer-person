package com.bank.customerperson.infrastructure.customer.gateway;

import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.infrastructure.config.db.repository.CustomerRepository;
import com.bank.customerperson.infrastructure.config.db.schema.CustomerSchema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public class CustomerDatabaseGateway implements CustomerGateway {
    private final CustomerRepository customerRepository;

    public CustomerDatabaseGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return customerRepository
                .findById(id)
                .map(CustomerSchema::toCustomer);
    }

    @Override
    public Page<Customer> findAllExcludingDeleted(Pageable pageable) {
        return customerRepository
                .findAllExcludingDeleted(pageable)
                .map(CustomerSchema::toCustomer);
    }
}
