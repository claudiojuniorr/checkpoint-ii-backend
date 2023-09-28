package com.claudioribeiro.clinicaodontologica.domain.entity.Service.ImplementsService;

import com.claudioribeiro.clinicaodontologica.domain.entity.ClinicaOdontologica;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface GenericService<T> {
    T criar(T entity);
    T buscarPorId(UUID id);
    List<T> listarTodos();
    T atualizar(T entity);

    @Transactional
    ClinicaOdontologica atualizarClinica(UUID id, ClinicaOdontologica novaClinica);

    void deletar(UUID id);
}
