package com.perinity.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perinity.domain.model.Tarefa;
import com.perinity.domain.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Transactional
	public Tarefa registrar(Tarefa tarefa) {
		return tarefaRepository.saveAndFlush(tarefa);
	}
	
	@Transactional
	public Tarefa finalizarTarefa(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		tarefa.get().setFinalizado(true);
		return tarefa.get();
	}
	
	
	
}
