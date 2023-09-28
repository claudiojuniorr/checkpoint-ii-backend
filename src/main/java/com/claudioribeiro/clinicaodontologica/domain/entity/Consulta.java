package com.claudioribeiro.clinicaodontologica.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "consulta")
public class Consulta {


    private static final Logger LOGGER = LoggerFactory.getLogger(Consulta.class);

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;

    @Column(length = 255)
    private String descricao;

    @Column(length = 255)
    private String motivoCancelamento;

    private Boolean cancelada;

    @OneToOne
    private Paciente paciente;

    @OneToOne
    private Dentista dentista;

    @OneToOne
    private ClinicaOdontologica clinica;
    @Transient
    private Instant createdAt;
    @Transient
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        LOGGER.info("Nova consulta criada para o paciente: {}", paciente.getNome());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        LOGGER.info("Consulta atualizada para o paciente: {}", paciente.getNome());
    }
}
