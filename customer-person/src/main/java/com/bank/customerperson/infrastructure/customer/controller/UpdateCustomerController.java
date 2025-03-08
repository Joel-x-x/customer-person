package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.infrastructure.customer.dto.CustomerUpdateData;
import com.bank.customerperson.usecase.customer.UpdateCustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Actualizar los detalles de un cliente",
            description = "Actualiza los detalles de un cliente existente en el sistema, utilizando su ID y los nuevos datos proporcionados.",
            tags = {"Clientes"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Cliente actualizado con éxito",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerPublicData.class),
                            examples = @ExampleObject(value = "{ \"id\": \"123e4567-e89b-12d3-a456-426614174000\", \"name\": \"Juan Pérez\", \"genre\": \"MASCULINO\", \"birthDate\": \"1990-05-15\", \"identification\": \"1234567890\", \"address\": \"Calle Falsa 123\", \"phone\": \"0987654321\" }")
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
                    responseCode = "404",
                    description = "Cliente no encontrado",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })

    @PutMapping("${api.prefix}/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData createCustomer(@PathVariable UUID id, @Valid @RequestBody CustomerUpdateData dados) throws CustomerNotFoundException {
        return new CustomerPublicData(updateCustomerUseCase.execute(id, dados));
    }
}
