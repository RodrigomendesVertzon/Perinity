package com.perinity.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perinity.domain.exceptions.EntidadeNaoEncontradaException;
import com.perinity.domain.exceptions.RegraDeNegocioException;
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
	
	@GetMapping("/pendentes")
	public ResponseEntity<?> listarTodos() {
		List<?> pessoas = tarefaRepository.findTop3ByIdPessoaIsNullOrderByPrazoAsc();
		return ResponseEntity.status(HttpStatus.OK).body(pessoas);
	}
	
	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody Tarefa tarefa) {
		try {
			tarefaService.registrar(tarefa);
			return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
		
		}catch (RegraDeNegocioException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("alocar/{tarefaId}")
	public ResponseEntity<?> alocarTarefa(@PathVariable Integer tarefaId,
			@RequestParam int pessoaId) {
		try {
			
			tarefaService.alocarPessoaEmTarefa(pessoaId, tarefaId);	
			Optional<Tarefa> novaTarefa = tarefaRepository.findById(tarefaId);
			return ResponseEntity.status(HttpStatus.OK).body(novaTarefa.get());
			
		}catch (RegraDeNegocioException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PutMapping("/finalizar/{tarefaId}")
	public ResponseEntity<?> finalizarTarefa(@PathVariable Integer tarefaId) {
		try {
			tarefaService.finalizarTarefa(tarefaId);
			return ResponseEntity.ok().build();
			
		}catch (RegraDeNegocioException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
