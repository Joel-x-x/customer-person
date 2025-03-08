package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.usecase.customer.PaginateCustomerUseCase;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaginateCustomerController {

    private final PaginateCustomerUseCase paginateCustomerUseCase;

    public PaginateCustomerController(PaginateCustomerUseCase paginateCustomerUseCase) {
        this.paginateCustomerUseCase = paginateCustomerUseCase;
    }

    @GetMapping("${api.prefix}/customers")
    @ResponseStatus(HttpStatus.OK)
    public Page<CustomerPublicData> paginateCustomers(
            @RequestParam int page,
            @RequestParam int size
    ) {
        Page<Customer> customers = this.paginateCustomerUseCase.execute(page, size);

        return customers.map(CustomerPublicData::new);
    }

}
