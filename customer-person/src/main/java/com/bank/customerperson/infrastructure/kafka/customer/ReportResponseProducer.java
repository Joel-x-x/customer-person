package com.bank.customerperson.infrastructure.kafka.customer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportResponseProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ReportResponseProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendReportResponse(String customerId, String customerData) {
        kafkaTemplate.send("report-response-topic", customerId, customerData);
    }
}
