package com.bank.customerperson.infrastructure.config.db.schema;

import com.bank.customerperson.entity.customer.model.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "customers")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class CustomerSchema extends PersonSchema {
    @NotBlank
    @Column(nullable = false, length = 64)
    private String password;

    public CustomerSchema(Customer customer) {
        this.setId(customer.getId());
        this.setName(customer.getName());
        this.setGenre(customer.getGenre());
        this.setBirthDate(customer.getBirthDate());
        this.setIdentification(customer.getIdentification());
        this.setAddress(customer.getAddress());
        this.setPhone(customer.getPhone());
        this.setPassword(customer.getPassword());
    }

    public Customer toCustomer() {
        return Customer.builder()
                .id(this.getId())
                .name(this.getName())
                .genre(this.getGenre())
                .birthDate(this.getBirthDate())
                .identification(this.getIdentification())
                .address(this.getAddress())
                .phone(this.getPhone())
                .password(this.getPassword())
                .build();
    }
}
