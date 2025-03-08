package com.bank.customerperson.infrastructure.customer.dto;

import com.bank.customerperson.usecase.customer.dto.ICustomerUpdateData;

public record CustomerUpdateData(
        String name,
        String genre,
        String birthDate,
        String identification,
        String address,
        String phone,
        String password
) implements ICustomerUpdateData {
}
