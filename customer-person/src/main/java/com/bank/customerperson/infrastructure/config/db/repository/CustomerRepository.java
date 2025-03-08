package com.bank.customerperson.infrastructure.config.db.repository;

import com.bank.customerperson.infrastructure.config.db.schema.CustomerSchema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerSchema, UUID> {
    @Query("SELECT c FROM CustomerSchema c WHERE c.deleted = false")
    Page<CustomerSchema> findAllExcludingDeleted(Pageable pageable);
}
