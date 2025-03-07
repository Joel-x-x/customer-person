package com.bank.customerperson.entity.person.model;

import com.bank.customerperson.entity.AbstractEntity;
import com.bank.customerperson.infrastructure.config.db.schema.Genre;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Person extends AbstractEntity<UUID> {

    private String name;
    private Genre genre;
    private LocalDateTime birthDate;
    private String identification;
    private String address;
    private String phone;
}
