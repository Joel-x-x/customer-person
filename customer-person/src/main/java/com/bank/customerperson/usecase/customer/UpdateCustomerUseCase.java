package com.bank.customerperson.usecase.customer;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.infrastructure.config.db.schema.Genre;
import com.bank.customerperson.usecase.customer.dto.ICustomerUpdateData;

import java.time.LocalDate;
import java.util.UUID;

public class UpdateCustomerUseCase {
    private final CustomerGateway customerGateway;

    public UpdateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(UUID id, ICustomerUpdateData dados) throws CustomerNotFoundException {
        Customer customer = this.customerGateway.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        if(dados.name() != null && !dados.name().isBlank()) {
            customer.setName(dados.name());
        }
        if(dados.genre() != null && !dados.genre().isBlank()) {
            customer.setGenre(Genre.valueOf(dados.genre()));
        }
        if(dados.birthDate() != null && !dados.birthDate().isBlank()) {
            customer.setBirthDate(LocalDate.parse(dados.birthDate()));
        }
        if(dados.identification() != null && !dados.identification().isBlank()) {
            customer.setIdentification(dados.identification());
        }
        if(dados.address() != null && !dados.address().isBlank()) {
            customer.setAddress(dados.address());
        }
        if(dados.phone() != null && !dados.phone().isBlank()) {
            customer.setPhone(dados.phone());
        }
        if(dados.password() != null && !dados.password().isBlank()) {
            customer.setPassword(dados.password());
        }

        return this.customerGateway.update(customer);
    }
}
