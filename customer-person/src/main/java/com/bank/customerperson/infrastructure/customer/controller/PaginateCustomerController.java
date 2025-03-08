package com.bank.customerperson.infrastructure.customer.controller;

import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.infrastructure.customer.dto.CustomerPublicData;
import com.bank.customerperson.usecase.customer.PaginateCustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Obtener una lista paginada de clientes",
            description = "Recupera una lista paginada de clientes, con la posibilidad de especificar el número de página y el tamaño de la página.",
            tags = {"Clientes"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Clientes obtenidos con éxito",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerPublicData.class),
                            examples = @ExampleObject(value = "[{ \"id\": \"123e4567-e89b-12d3-a456-426614174000\", \"name\": \"Juan Pérez\", \"genre\": \"MASCULINO\", \"birthDate\": \"1990-05-15\", \"identification\": \"1234567890\", \"address\": \"Calle Falsa 123\", \"phone\": \"0987654321\" }, { \"id\": \"123e4567-e89b-12d3-a456-426614174001\", \"name\": \"Ana López\", \"genre\": \"FEMENINO\", \"birthDate\": \"1985-11-23\", \"identification\": \"0987654321\", \"address\": \"Calle Verdadera 456\", \"phone\": \"0987654322\" }]")
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
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })

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
