package com.bank.customerperson.usecase.customer;

import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.infrastructure.config.db.schema.Genre;
import com.bank.customerperson.usecase.customer.dto.ICustomerRegistrationData;

import java.time.LocalDateTime;

public class CreateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public CreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(ICustomerRegistrationData dados) {
        Customer customer = Customer.builder()
                .name(dados.name())
                .genre(Genre.valueOf(dados.genre()))
                .birthDate(LocalDateTime.parse(dados.birthDate()))
                .identification(dados.identification())
                .address(dados.address())
                .phone(dados.phone())
                .password(dados.password())
                .build();

        return this.customerGateway.create(customer);
    }
}
