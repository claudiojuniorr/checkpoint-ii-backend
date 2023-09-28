package com.claudioribeiro.clinicaodontologica.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dentista")
public class Dentista {

    private static final Logger LOGGER = LoggerFactory.getLogger(Dentista.class);

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 255)
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 80)
    private String especialidade;

    @Column(length = 2)
    private String sexo;

    @OneToOne
    private Contato contato;
    @Transient
    private Instant createdAt;
    @Transient
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        LOGGER.info("Novo dentista criado: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        LOGGER.info("Dentista atualizado: {}", nome);
    }
}
