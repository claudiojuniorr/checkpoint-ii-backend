package com.claudioribeiro.clinicaodontologica.domain.entity.Repository;

import com.claudioribeiro.clinicaodontologica.domain.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
}