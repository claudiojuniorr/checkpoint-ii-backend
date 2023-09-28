package com.claudioribeiro.clinicaodontologica.domain.entity.Repository;

import com.claudioribeiro.clinicaodontologica.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}