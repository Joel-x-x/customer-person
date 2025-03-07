package com.bank.customerperson.entity.person.gateway;

import com.bank.customerperson.entity.person.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonaGateway {
    Person create(Person person);
    Person update(Person person);
    void delete(Person person);

    Optional<Person> findById(UUID id);
    List<Person> findAll();
}
