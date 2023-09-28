package com.claudioribeiro.clinicaodontologica.domain.entity.Service;

import com.claudioribeiro.clinicaodontologica.domain.entity.ClinicaOdontologica;
import com.claudioribeiro.clinicaodontologica.domain.entity.Service.ImplementsService.GenericService;
import com.claudioribeiro.clinicaodontologica.domain.entity.Repository.ClinicaOdontologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Repository
public class ClinicaOdontologicaService implements GenericService<ClinicaOdontologica> {

    private final ClinicaOdontologicaRepository repository;

    @Autowired
    public ClinicaOdontologicaService(ClinicaOdontologicaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ClinicaOdontologica criar(ClinicaOdontologica clinicaOdontologica) {
        // Validação dos dados (exemplo simples)
        if (clinicaOdontologica.getNome() == null || clinicaOdontologica.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da clínica é obrigatório.");
        }

        // Se necessário, adicione lógica para gerar valores padrão ou calcular campos

        // Chamar o método repository.save para persistir a clínica
        return repository.save(clinicaOdontologica);
    }

    @Override
    @Transactional(readOnly = true)
    public ClinicaOdontologica buscarPorId(UUID id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ClinicaOdontologica> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public ClinicaOdontologica atualizar(ClinicaOdontologica entity) {
        // Verifique se a clínica odontológica com o ID fornecido existe no banco de dados
        ClinicaOdontologica clinicaExistente = repository.findById(entity.getId()).orElse(null);

        if (clinicaExistente != null) {
            // Atualize os campos da clínica existente com base na entidade recebida
            clinicaExistente.setNome(entity.getNome());
            clinicaExistente.setCnpj(entity.getCnpj());
            clinicaExistente.setRazaoSocial(entity.getRazaoSocial());
            clinicaExistente.setDescricao(entity.getDescricao());
            clinicaExistente.setEndereco(entity.getEndereco());
            clinicaExistente.setContato(entity.getContato());

            // Salve as alterações no banco de dados
            return repository.save(clinicaExistente);
        } else {
            // Clínica não encontrada, você pode escolher como lidar com isso, lançar uma exceção, por exemplo
            throw new RuntimeException("Clínica não encontrada com o ID fornecido: " + entity.getId());
        }
    }

    @Override
    @Transactional
    public ClinicaOdontologica atualizarClinica(UUID id, ClinicaOdontologica novaClinica) {
        ClinicaOdontologica clinicaExistente = repository.findById(id).orElse(null);
        if (clinicaExistente != null) {
            // Atualize os campos necessários da clínicaExistente com base na novaClinica
            clinicaExistente.setNome(novaClinica.getNome());
            clinicaExistente.setCnpj(novaClinica.getCnpj());
            clinicaExistente.setRazaoSocial(novaClinica.getRazaoSocial());
            clinicaExistente.setDescricao(novaClinica.getDescricao());
            clinicaExistente.setEndereco(novaClinica.getEndereco());
            clinicaExistente.setContato(novaClinica.getContato());
            return repository.save(clinicaExistente);
        }
        return null;
    }

    @Override
    @Transactional
    public void deletar(UUID id) {
        // Lógica para excluir uma clínica odontológica pelo ID
        repository.deleteById(id);
    }
}
