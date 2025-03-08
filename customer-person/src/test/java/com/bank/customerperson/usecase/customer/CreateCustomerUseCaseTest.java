package com.bank.customerperson.usecase.customer;

import com.bank.customerperson.entity.customer.gateway.CustomerGateway;
import com.bank.customerperson.entity.customer.model.Customer;
import com.bank.customerperson.infrastructure.config.db.schema.Genre;
import com.bank.customerperson.usecase.customer.dto.ICustomerRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateCustomerUseCaseTest {

    private CustomerGateway customerGateway;
    private CreateCustomerUseCase createCustomerUseCase;
    private ICustomerRegistrationData customerRegistrationData;

    @BeforeEach
    void setUp() {
        customerGateway = mock(CustomerGateway.class);
        createCustomerUseCase = new CreateCustomerUseCase(customerGateway);
        customerRegistrationData = mock(ICustomerRegistrationData.class);

        Customer mockCustomer = Customer.builder()
                .name("Juan Pérez")
                .genre(Genre.MALE)
                .birthDate(LocalDate.parse("1990-05-15"))
                .identification("1234567890")
                .address("Calle Falsa 123")
                .phone("0987654321")
                .password("SecurePassword")
                .build();
        when(customerGateway.create(any(Customer.class))).thenReturn(mockCustomer);
    }

    @Test
    void execute() {
        when(customerRegistrationData.name()).thenReturn("Juan Pérez");
        when(customerRegistrationData.genre()).thenReturn("MALE");
        when(customerRegistrationData.birthDate()).thenReturn("1990-05-15");
        when(customerRegistrationData.identification()).thenReturn("1234567890");
        when(customerRegistrationData.address()).thenReturn("Calle Falsa 123");
        when(customerRegistrationData.phone()).thenReturn("0987654321");
        when(customerRegistrationData.password()).thenReturn("SecurePassword");

        Customer createdCustomer = createCustomerUseCase.execute(customerRegistrationData);

        assertNotNull(createdCustomer);
        assertEquals("Juan Pérez", createdCustomer.getName());
        assertEquals(Genre.MALE, createdCustomer.getGenre());
        assertEquals("1990-05-15", createdCustomer.getBirthDate().toString());
        assertEquals("1234567890", createdCustomer.getIdentification());
        assertEquals("Calle Falsa 123", createdCustomer.getAddress());
        assertEquals("0987654321", createdCustomer.getPhone());
        assertEquals("SecurePassword", createdCustomer.getPassword());

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerGateway).create(customerCaptor.capture());

        assertEquals("Juan Pérez", customerCaptor.getValue().getName());
    }

    @Test
    void validWhenGatewayFails() {
        when(customerRegistrationData.name()).thenReturn("Juan Pérez");
        when(customerRegistrationData.genre()).thenReturn("MALE");
        when(customerRegistrationData.birthDate()).thenReturn("1990-05-15");
        when(customerRegistrationData.identification()).thenReturn("1234567890");
        when(customerRegistrationData.address()).thenReturn("Calle Falsa 123");
        when(customerRegistrationData.phone()).thenReturn("0987654321");
        when(customerRegistrationData.password()).thenReturn("SecurePassword");

        when(customerGateway.create(any(Customer.class)))
                .thenThrow(new RuntimeException("Error al guardar el cliente en la base de datos"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            createCustomerUseCase.execute(customerRegistrationData);
        });

        assertEquals("Error al guardar el cliente en la base de datos", exception.getMessage());

        verify(customerGateway).create(any(Customer.class));
    }

}