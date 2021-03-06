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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perinity.api.dto.PessoaComHorasGastasDto;
import com.perinity.api.dto.PessoaDto;
import com.perinity.domain.exceptions.EntidadeEmUsoException;
import com.perinity.domain.exceptions.EntidadeNaoEncontradaException;
import com.perinity.domain.exceptions.RegraDeNegocioException;
import com.perinity.domain.model.Pessoa;
import com.perinity.domain.model.Tarefa;
import com.perinity.domain.repository.PessoaRepository;
import com.perinity.domain.repository.TarefaRepository;
import com.perinity.domain.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired 
	private TarefaRepository tarefaRepository;

	@GetMapping
	public ResponseEntity<?> listarTodosComTotalHorasGastas() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		double soma = tarefaRepository.tempoTotalTarefas();
		
		PessoaDto pessoaDto = new PessoaDto();
		pessoaDto.setPessoas(pessoas);
		pessoaDto.setTotalHorasGastas(soma);
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaDto);
	}
	
	@GetMapping("/gastos")
	public ResponseEntity<?> listarPorNomeComMedia(@RequestParam("nome") String nome) {
		
		Pessoa pessoa = pessoaRepository.findByNome(nome);
		int media = tarefaRepository.mediaTempoTarefas(pessoa.getId());
		List<Tarefa> tarefas = tarefaRepository.findAllByIdPessoa(pessoa);
		
		PessoaComHorasGastasDto pessoaDto = new PessoaComHorasGastasDto();
		pessoaDto.setPessoa(pessoa);
		pessoaDto.setMediaHorasGastasPorTarefa(media);
		pessoaDto.setTarefa(tarefas);
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaDto);
	}
	
	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody Pessoa pessoa) {
		try {
			pessoaService.registrar(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		}catch (RegraDeNegocioException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@Transactional
	@PutMapping("/{pessoaId}")
	public ResponseEntity<?> alterar(@RequestBody Pessoa pessoa,
			@PathVariable Integer pessoaId) {
		try {
			Optional<Pessoa> pessoaAtual = pessoaRepository.findById(pessoaId);			
			if (pessoaAtual != null) {
				BeanUtils.copyProperties(pessoa, pessoaAtual.get(), "id");
				Pessoa pessoaSalva = pessoaService.registrar(pessoaAtual.get());
				return ResponseEntity.status(HttpStatus.OK).body(pessoaSalva);
			}
			return ResponseEntity.notFound().build();
			
		}catch (RegraDeNegocioException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<?> remover(@PathVariable Integer pessoaId) {
		try {
			pessoaService.remover(pessoaId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
}
