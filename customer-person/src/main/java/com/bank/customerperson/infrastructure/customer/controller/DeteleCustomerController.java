package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.usecase.customer.DeleteCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class DeteleCustomerController {
    private final DeleteCustomerUseCase deleteCustomerUseCase;

    public DeteleCustomerController(DeleteCustomerUseCase deleteCustomerUseCase) {
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData deleteCustomer(@PathVariable UUID id) throws CustomerNotFoundException {
        return new CustomerPublicData(deleteCustomerUseCase.execute(id));
    }
}
