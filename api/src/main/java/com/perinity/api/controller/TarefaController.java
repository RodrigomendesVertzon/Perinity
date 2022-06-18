package com.perinity.api.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perinity.domain.model.Pessoa;
import com.perinity.domain.model.Tarefa;
import com.perinity.domain.repository.TarefaRepository;
import com.perinity.domain.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody Tarefa tarefa) {
		try {
			tarefaService.registrar(tarefa);
			return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("alocar/{tarefaId}")
	public ResponseEntity<?> alocarTarefa(@PathVariable Long tarefaId,
			@RequestBody Pessoa pessoa) {
		try {
			Optional<Tarefa> tarefaAtual = tarefaRepository.findById(tarefaId);
			if (tarefaAtual != null) {
				BeanUtils.copyProperties(tarefaAtual.get().getIdPessoa(), tarefaAtual.get().getIdPessoa());
				Tarefa tarefaSalva = tarefaService.registrar(tarefaAtual.get());
				return ResponseEntity.status(HttpStatus.OK).body(tarefaSalva);
			}
			return ResponseEntity.notFound().build();
			
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/finalizar/{tarefaId}")
	public ResponseEntity<?> finalizarTarefa(@PathVariable Long tarefaId) {
		try {
			tarefaService.finalizarTarefa(tarefaId);
			return ResponseEntity.ok().build();
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
