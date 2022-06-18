package com.perinity.api.controller;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perinity.domain.model.Pessoa;
import com.perinity.domain.repository.PessoaRepository;
import com.perinity.domain.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public ResponseEntity<?> listarTodos() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoas);
	}
	
	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody Pessoa pessoa) {
		try {
			pessoaService.registrar(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@Transactional
	@PutMapping("/{pessoaId}")
	public ResponseEntity<?> alterar(@RequestBody Pessoa pessoa,
			@PathVariable Long pessoaId) {
		try {
			Optional<Pessoa> pessoaAtual = pessoaRepository.findById(pessoaId);			
			if (pessoaAtual != null) {
				BeanUtils.copyProperties(pessoa, pessoaAtual.get(), "id");
				Pessoa pessoaSalva = pessoaService.registrar(pessoaAtual.get());
				return ResponseEntity.status(HttpStatus.OK).body(pessoaSalva);
			}
			return ResponseEntity.notFound().build();
			
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<?> remover(@PathVariable Long pessoaId) {
		try {
			pessoaService.remover(pessoaId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}