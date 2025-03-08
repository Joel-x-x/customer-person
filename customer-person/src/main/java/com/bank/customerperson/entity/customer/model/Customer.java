package com.bank.customerperson.entity.customer.model;

import com.bank.customerperson.entity.person.model.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Customer extends Person {
    private String password;
}
