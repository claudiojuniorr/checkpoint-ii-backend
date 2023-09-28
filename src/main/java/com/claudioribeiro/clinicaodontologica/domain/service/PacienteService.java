package com.claudioribeiro.clinicaodontologica.domain.service;

import com.claudioribeiro.clinicaodontologica.domain.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {


    Paciente criarPaciente(Paciente paciente);
    Optional<Paciente> buscarPorId(Integer id);
    List<Paciente> buscarTodosPacientes();
    void excluirPaciente(Integer id);


}
