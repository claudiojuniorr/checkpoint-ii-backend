package com.claudioribeiro.clinicaodontologica.domain.entity.Service;

import com.claudioribeiro.clinicaodontologica.domain.entity.Paciente;
import com.claudioribeiro.clinicaodontologica.domain.entity.Repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    @Autowired
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Paciente criarPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    @Transactional(readOnly = true)
    public Paciente buscarPacientePorId(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Paciente> listarPacientes() {
        return repository.findAll();
    }

    @Transactional
    public Paciente atualizarPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    @Transactional
    public void deletarPaciente(UUID id) {
        repository.deleteById(id);
    }
}
