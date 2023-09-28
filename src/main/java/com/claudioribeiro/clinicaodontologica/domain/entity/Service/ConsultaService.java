package com.claudioribeiro.clinicaodontologica.domain.entity.Service;

import com.claudioribeiro.clinicaodontologica.domain.entity.Consulta;
import com.claudioribeiro.clinicaodontologica.domain.entity.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;


    @Autowired
    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Consulta criarConsulta(Consulta consulta) {
        return repository.save(consulta);
    }

    @Transactional(readOnly = true)
    public Consulta buscarConsultaPorId(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Consulta> listarConsultas() {
        return repository.findAll();
    }

    @Transactional
    public Consulta atualizarConsulta(Consulta consulta) {
        return repository.save(consulta);
    }

    @Transactional
    public void deletarConsulta(UUID id) {
        repository.deleteById(id);
    }
}
