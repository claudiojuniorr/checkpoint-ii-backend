package com.claudioribeiro.clinicaodontologica.domain.entity.Repository;

import com.claudioribeiro.clinicaodontologica.domain.entity.ClinicaOdontologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicaOdontologicaRepository extends JpaRepository<ClinicaOdontologica, UUID> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}