package com.bank.customerperson.infrastructure.config.web;

import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.infrastructure.config.db.repository.CustomerRepository;
import com.bank.customerperson.infrastructure.customer.gateway.CustomerDatabaseGateway;
import com.bank.customerperson.usecase.customer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    // Customer
    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new CreateCustomerUseCase(customerGateway);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new DeleteCustomerUseCase(customerGateway);
    }

    @Bean
    public GetCustomerUseCase getCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new GetCustomerUseCase(customerGateway);
    }

    @Bean
    public PaginateCustomerUseCase paginateCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new PaginateCustomerUseCase(customerGateway);
    }

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(CustomerRepository customerRepository) {
        CustomerGateway customerGateway = new CustomerDatabaseGateway(customerRepository);
        return new UpdateCustomerUseCase(customerGateway);
    }

}
