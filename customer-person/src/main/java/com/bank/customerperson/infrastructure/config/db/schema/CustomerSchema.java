package com.bank.customerperson.infrastructure.config.db.schema;

import com.bank.customerperson.entity.customer.model.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "customers")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerSchema extends PersonSchema {

    @NotBlank
    @Column(nullable = false, length = 64)
    private String password;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PersonSchema person;

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
