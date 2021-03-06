package com.perinity.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perinity.api.dto.DepartamentoDto;
import com.perinity.domain.model.Departamento;
import com.perinity.domain.model.Pessoa;
import com.perinity.domain.model.Tarefa;
import com.perinity.domain.repository.DepartamentoRepository;
import com.perinity.domain.repository.PessoaRepository;
import com.perinity.domain.repository.TarefaRepository;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private TarefaRepository tarefaRepository;
 
	@GetMapping
	public ResponseEntity<?> listarTodos() {
		
		List<Departamento> departamentos = departamentoRepository.findAll();
		List<Pessoa> pessoas = pessoaRepository.findAll();
		List<Tarefa> tarefas = tarefaRepository.findAll();
		
		List<DepartamentoDto> todosOsDepartamentos = new ArrayList<>();
		
		for (int i = 0; i < departamentos.size(); i++) {
			
			DepartamentoDto departamento = new DepartamentoDto();
			departamento.setDepartamento(departamentos.get(i));
			
			for (int j = 0; j < pessoas.size(); j++) {
				if (pessoas.get(j).getIdDepartamento() == departamentos.get(i)) {
					departamento.setQuantidadePessoas(
							departamento.getQuantidadePessoas() + 1);
				}
			}
			for (int k = 0; k < tarefas.size(); k++ ) {
				if (tarefas.get(k).getIdDepartamento() == departamentos.get(i)) {
					departamento.setQuantidadeTarefas(
							departamento.getQuantidadeTarefas() + 1);
				}
			}
			todosOsDepartamentos.add(departamento);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(todosOsDepartamentos);
	}
}
