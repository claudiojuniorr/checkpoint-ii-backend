package com.claudioribeiro.clinicaodontologica;

import com.claudioribeiro.clinicaodontologica.domain.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClinicaOdontologicaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCriarPaciente() throws Exception {
		UUID id = UUID.fromString("b9d8f8c8-ce66-48e6-829a-4965b769ec94");

		Paciente paciente = new Paciente();
		paciente.setId(id);
		paciente.setNome("João");
		paciente.setDataNascimento(LocalDate.parse("1990-01-01"));
		paciente.setSexo("M");

		mockMvc.perform(post("/pacientes")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(paciente)))
				.andExpect(status().isCreated());
	}

	@Test
	void testBuscarPacientePorId() throws Exception {
		UUID id = UUID.fromString("b9d8f8c8-ce66-48e6-829a-4965b769ec94");
		mockMvc.perform(get("/pacientes/" + id.toString()))
				.andExpect(status().isOk());
	}

	@Test
	void testListarPacientes() throws Exception {
		mockMvc.perform(get("/pacientes"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").exists())
				.andExpect(jsonPath("$[0].nome").exists())
				.andExpect(jsonPath("$[0].dataNascimento").exists())
				.andExpect(jsonPath("$[0].sexo").exists());
	}

	@Test
	void testAtualizarPaciente() throws Exception {
		Paciente paciente = new Paciente();
		paciente.setNome("Novo Nome");
		paciente.setDataNascimento(LocalDate.parse("1990-01-01"));
		paciente.setSexo("F");

		mockMvc.perform(put("/pacientes/{id}", UUID.fromString("57bebc49-735d-403d-9dfd-9faa325f9b11"))
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(paciente)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("611856ed-1bc9-4f6e-af8c-eface3b90c6f"));
	}


	@Test
	void testDeletarPaciente() throws Exception {
		UUID id = UUID.fromString("611856ed-1bc9-4f6e-af8c-eface3b90c6f");
		mockMvc.perform(delete("/pacientes/" + id.toString()))
				.andExpect(status().isNoContent());
	}
}
