package com.perinity.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.perinity.domain.exceptions.RegraDeNegocioException;
import com.perinity.domain.model.Pessoa;
import com.perinity.domain.model.Tarefa;
import com.perinity.domain.repository.PessoaRepository;
import com.perinity.domain.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public Tarefa registrar(Tarefa tarefa) {
		
		if (StringUtils.isEmpty(tarefa.getTitulo())) {
			throw new RegraDeNegocioException("O titulo da tarefa deve ser informado.");
		}
		if (StringUtils.isEmpty(tarefa.getDuracao())) {
			throw new RegraDeNegocioException("A duracao (em dias) da tarefa deve ser informada.");
		}
		if(StringUtils.isEmpty(tarefa.getPrazo())) {
			throw new RegraDeNegocioException("O prazo da tarefa deve ser informado.");
		}
		if (StringUtils.isEmpty(tarefa.getIdDepartamento())) {
			throw new RegraDeNegocioException("O idDepartamrnto deve ser informado.");
		}
		
		return tarefaRepository.saveAndFlush(tarefa);
	}
	
	@Transactional
	public Tarefa alocarPessoaEmTarefa(Integer pessoaId, Integer tarefaId) {
		
		Optional<Tarefa> tarefa = tarefaRepository.findById(tarefaId);
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
		
		if (pessoa.get().getIdDepartamento() != tarefa.get().getIdDepartamento()) {
			throw new RegraDeNegocioException(
					"Este funcionário não pertence ao departamento dessa tarefa.");
		}
		
		tarefa.get().setIdPessoa(pessoa.get());
		return tarefa.get();
	}
	
	@Transactional
	public Tarefa finalizarTarefa(Integer id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		
		if (tarefa.get().isFinalizado()) {
			throw new RegraDeNegocioException("Esta tarefa já foi finalizada.");
		}

		tarefa.get().setFinalizado(true);
		return tarefa.get();
	}
}
