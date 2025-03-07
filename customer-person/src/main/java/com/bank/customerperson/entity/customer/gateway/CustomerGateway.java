package com.bank.customerperson.entity.customer.gateway;

import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.infrastructure.config.db.schema.CustomerSchema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerGateway {
    Customer create(Customer customer);
    Customer update(Customer customer);
//    void delete(Customer customer);

    Optional<Customer> findById(UUID id);
    Page<Customer> findAllExcludingDeleted(Pageable pageable);
}
