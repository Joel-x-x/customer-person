package com.bank.customerperson.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

    private ID id;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
