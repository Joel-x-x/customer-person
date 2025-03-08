package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.entity.customer.exception.CustomerNotFoundException;
import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.usecase.customer.DeleteCustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeteleCustomerController {
    private final DeleteCustomerUseCase deleteCustomerUseCase;

    public DeteleCustomerController(DeleteCustomerUseCase deleteCustomerUseCase) {
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }

    @Operation(
            summary = "Eliminar un cliente",
            description = "Elimina un cliente del sistema por su ID y devuelve los detalles públicos del cliente eliminado.",
            tags = {"Clientes"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Cliente eliminado con éxito",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerPublicData.class),
                            examples = @ExampleObject(value = "{ \"id\": \"123e4567-e89b-12d3-a456-426614174000\", \"name\": \"Juan Pérez\", \"genre\": \"MASCULINO\", \"birthDate\": \"1990-05-15\", \"identification\": \"1234567890\", \"address\": \"Calle Falsa 123\", \"phone\": \"0987654321\" }")
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

    @DeleteMapping("${api.prefix}/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerPublicData deleteCustomer(@PathVariable UUID id) throws CustomerNotFoundException {
        return new CustomerPublicData(deleteCustomerUseCase.execute(id));
    }
}
