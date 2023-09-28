package com.claudioribeiro.clinicaodontologica.domain.entity.Repository;

import com.claudioribeiro.clinicaodontologica.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}