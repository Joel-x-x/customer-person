package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.usecase.customer.CreateCustomerUseCase;
import com.bank.customerperson.usecase.customer.GetCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GetCustomerController {
    private final GetCustomerUseCase getCustomerUseCase;

    public GetCustomerController(GetCustomerUseCase getCustomerUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
    }

    @GetMapping("${api.prefix}/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData getCustomerPublicData(UUID id) throws CustomerNotFoundException {
        return new CustomerPublicData(getCustomerUseCase.execute(id));
    }
}
