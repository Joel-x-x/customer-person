package com.bank.customerperson.infrastructure.customer.dto;

import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.usecase.customer.dto.ICustomerPublicData;

public record CustomerPublicData(
        String id,
        String name,
        String genre,
        String birthDate,
        String identification,
        String address,
        String phone
) implements ICustomerPublicData {
    public CustomerPublicData(Customer customer) {
        this(
                customer.getId().toString(),
                customer.getName(),
                customer.getGenre().name(),
                customer.getBirthDate().toString(),
                customer.getIdentification(),
                customer.getAddress(),
                customer.getPhone()
        );
    }
}
