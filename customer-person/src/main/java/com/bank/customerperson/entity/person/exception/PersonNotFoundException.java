package com.bank.customerperson.entity.person.exception;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {
        super("Persona no encontrada");
    }
}
