package com.claudioribeiro.clinicaodontologica.controller;

import com.claudioribeiro.clinicaodontologica.domain.entity.Contato;
import com.claudioribeiro.clinicaodontologica.domain.entity.Service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) {
        Contato novoContato = contatoService.criarContato(contato);
        return new ResponseEntity<>(novoContato, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarContatoPorId(@PathVariable UUID id) {
        Contato contato = contatoService.buscarContatoPorId(id);
        if (contato != null) {
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarContatos() {
        List<Contato> contatos = contatoService.listarContatos();
        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizarContato(@PathVariable UUID id, @RequestBody Contato contato) {
        Contato atualizadoContato = contatoService.atualizarContato(contato);
        if (atualizadoContato != null) {
            return ResponseEntity.ok(atualizadoContato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContato(@PathVariable UUID id) {
        contatoService.deletarContato(id);
        return ResponseEntity.noContent().build();
    }
}
