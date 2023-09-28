package com.claudioribeiro.clinicaodontologica.domain.entity.Service;

import com.claudioribeiro.clinicaodontologica.domain.entity.Endereco;

import com.claudioribeiro.clinicaodontologica.domain.entity.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Endereco criarEndereco(Endereco endereco) {
        return repository.save(endereco);
    }

    @Transactional(readOnly = true)
    public Endereco buscarEnderecoPorId(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Endereco> listarEnderecos() {
        return repository.findAll();
    }

    @Transactional
    public Endereco atualizarEndereco(Endereco endereco) {
        return repository.save(endereco);
    }

    @Transactional
    public void deletarEndereco(UUID id) {
        repository.deleteById(id);
    }
}
