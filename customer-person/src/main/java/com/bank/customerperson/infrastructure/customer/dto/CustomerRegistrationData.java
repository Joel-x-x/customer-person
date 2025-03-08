package com.bank.customerperson.infrastructure.customer.dto;

import com.bank.customerperson.usecase.customer.dto.ICustomerRegistrationData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerRegistrationData(
    @NotBlank
    @Size(min = 2, max = 100)
    String name,
    @NotBlank
    String genre,
    @NotBlank
//    @Past
    String birthDate,
    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    String identification,
    @NotBlank
    String address,
    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    String phone,
    @NotBlank
    @Size(min = 6, max = 20)
    String password
) implements ICustomerRegistrationData {}
