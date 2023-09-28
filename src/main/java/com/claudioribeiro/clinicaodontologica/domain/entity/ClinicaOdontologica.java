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
@Table(name = "clinicas_odontologicas")
public class ClinicaOdontologica {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClinicaOdontologica.class);

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 255)
    private String nome;

    @Column(length = 20)
    private String cnpj;

    @Column(length = 255)
    private String razaoSocial;

    @Column(length = 255)
    private String descricao;

    @OneToOne
    private Endereco endereco;

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
        LOGGER.info("Nova clínica criada: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        LOGGER.info("Clínica atualizada: {}", nome);
    }
}
