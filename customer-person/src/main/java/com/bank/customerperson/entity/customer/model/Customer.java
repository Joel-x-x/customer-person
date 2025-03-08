package com.bank.customerperson.entity.customer.model;

import com.bank.customerperson.entity.person.model.Person;
import com.bank.customerperson.infrastructure.config.db.schema.PersonSchema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Customer extends Person {
    private String password;
}
