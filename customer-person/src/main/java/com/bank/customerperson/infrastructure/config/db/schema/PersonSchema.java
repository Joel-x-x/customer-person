package com.bank.customerperson.infrastructure.config.db.schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persons")
public abstract class PersonSchema extends AbstractEntitySchema<UUID> {

    @NotBlank
    @Column(length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Column(nullable = false)
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 20)
    @Column(length = 20, unique = true)
    private String identification;

    @NotBlank
    @Column(length = 200)
    private String address;

    @NotBlank
    @Size(max = 15)
    @Column(length = 15)
    private String phone;

}
