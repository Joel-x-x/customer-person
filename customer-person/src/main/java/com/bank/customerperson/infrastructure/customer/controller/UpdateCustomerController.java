package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.infrastructure.customer.dto.CustomerUpdateData;
import com.bank.customerperson.usecase.customer.UpdateCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UpdateCustomerController {

    private final UpdateCustomerUseCase updateCustomerUseCase;

    public UpdateCustomerController(UpdateCustomerUseCase updateCustomerUseCase) {
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @PutMapping("${api.prefix}/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData createCustomer(@PathVariable UUID id, @Valid @RequestBody CustomerUpdateData dados) throws CustomerNotFoundException {
        return new CustomerPublicData(updateCustomerUseCase.execute(id, dados));
    }
}
