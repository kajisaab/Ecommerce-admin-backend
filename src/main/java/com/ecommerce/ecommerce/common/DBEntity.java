package com.ecommerce.ecommerce.common;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@MappedSuperclass
@Data
public abstract class DBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, insertable = false)
    private String id;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean isDeleted;


    @Column(updatable = false)
    private Instant createdAt;
    private Instant modifiedAt;


    @PrePersist
    public void createdTimeStamps() {
        modifiedAt = Instant.now();
        createdAt = Instant.now();
    }

    @PreUpdate
    public void updateTimeStamps() {
        modifiedAt = Instant.now();
    }
}
