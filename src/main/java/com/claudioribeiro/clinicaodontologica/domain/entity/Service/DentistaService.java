package com.claudioribeiro.clinicaodontologica.domain.entity.Service;

import com.claudioribeiro.clinicaodontologica.domain.entity.Dentista;

import com.claudioribeiro.clinicaodontologica.domain.entity.Repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DentistaService {

    private final DentistaRepository repository;

    @Autowired
    public DentistaService(DentistaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Dentista criarDentista(Dentista dentista) {
        return repository.save(dentista);
    }

    @Transactional(readOnly = true)
    public Dentista buscarDentistaPorId(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Dentista> listarDentistas() {
        return repository.findAll();
    }

    @Transactional
    public Dentista atualizarDentista(Dentista dentista) {
        return repository.save(dentista);
    }

    @Transactional
    public void deletarDentista(UUID id) {
        repository.deleteById(id);
    }
}
