package com.bank.customerperson.infrastructure.config.db.repository;

import com.bank.customerperson.infrastructure.config.db.schema.PersonSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonSchema, UUID> {
}
