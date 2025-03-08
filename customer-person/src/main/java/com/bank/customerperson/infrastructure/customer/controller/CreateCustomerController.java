package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.infrastructure.customer.dto.CustomerRegistrationData;
import com.bank.customerperson.usecase.customer.CreateCustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;

    public CreateCustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Crea un nuevo cliente en el sistema y devuelve los detalles públicos del cliente recién creado.",
            tags = {"Clientes"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Cliente creado con éxito",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerPublicData.class),
                            examples = @ExampleObject(value = "{ \"id\": \"123e4567-e89b-12d3-a456-426614174000\", \"name\": \"Juan Pérez\", \"genre\": \"M\", \"birthDate\": \"1990-05-15\", \"identification\": \"1234567890\", \"address\": \"Calle Falsa 123\", \"phone\": \"0987654321\" }")
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "No autorizado",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })
    @PostMapping("${api.prefix}/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerPublicData createCustomer(@Valid @RequestBody CustomerRegistrationData dados) {
        return new CustomerPublicData(createCustomerUseCase.execute(dados));
    }
}
