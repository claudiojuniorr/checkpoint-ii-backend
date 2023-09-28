package com.claudioribeiro.clinicaodontologica.domain.entity.Service;

import com.claudioribeiro.clinicaodontologica.domain.entity.Contato;

import com.claudioribeiro.clinicaodontologica.domain.entity.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    @Autowired
    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Contato criarContato(Contato contato) {
        return repository.save(contato);
    }

    @Transactional(readOnly = true)
    public Contato buscarContatoPorId(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Contato> listarContatos() {
        return repository.findAll();
    }

    @Transactional
    public Contato atualizarContato(Contato contato) {
        return repository.save(contato);
    }

    @Transactional
    public void deletarContato(UUID id) {
        repository.deleteById(id);
    }
}
