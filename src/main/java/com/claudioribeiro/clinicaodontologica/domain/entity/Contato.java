package com.claudioribeiro.clinicaodontologica.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Instant;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contato")
public class Contato {

    private static final Logger LOGGER = LoggerFactory.getLogger(Contato.class);

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String telefone;
    @Transient
    private Instant createdAt;
    @Transient
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        LOGGER.info("Novo contato criado com email: {}", email);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        LOGGER.info("Contato atualizado com email: {}", email);
    }
}
