package com.bank.customerperson.infrastructure.kafka.customer;

import com.bank.customerperson.infrastructure.config.db.repository.CustomerRepository;
import com.bank.customerperson.infrastructure.config.db.schema.CustomerSchema;
import com.bank.customerperson.infrastructure.kafka.customer.dto.CustomerPublicData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReportRequestConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CustomerRepository customerRepository; // Tu repositorio de clientes

    public ReportRequestConsumer(KafkaTemplate<String, String> kafkaTemplate, CustomerRepository customerRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.customerRepository = customerRepository;
    }

    @KafkaListener(topics = "customer-data-request", groupId = "bank-group")
    public void listenCustomerRequest(String customerId) throws JsonProcessingException {
        CustomerSchema customer = customerRepository.findById(UUID.fromString(customerId))
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        CustomerPublicData customerPublicData = new CustomerPublicData(
                customer.toCustomer().getId().toString(),
                customer.toCustomer().getName(),
                customer.toCustomer().getGenre().toString(),
                customer.toCustomer().getBirthDate().toString(),
                customer.toCustomer().getIdentification(),
                customer.toCustomer().getAddress(),
                customer.toCustomer().getPhone()
        );

        kafkaTemplate.send("customer-data-response",
                new ObjectMapper().writeValueAsString(customerPublicData));
    }
}
