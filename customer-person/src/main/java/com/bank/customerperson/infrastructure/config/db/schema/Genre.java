package com.bank.customerperson.infrastructure.config.db.schema;

import lombok.Getter;

@Getter
public enum Genre {
    MALE("Masculino"),
    FEMALE("Femenino"),
    OTHER("Otro");

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }
}
