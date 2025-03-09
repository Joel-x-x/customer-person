package com.bank.customerperson.infrastructure.kafka.customer.dto;

public record CustomerPublicData(
        String id,
        String name,
        String genre,
        String birthDate,
        String identification,
        String address,
        String phone
) {}
