package com.perinity.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.perinity.domain.model.Pessoa;
import com.perinity.domain.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public Pessoa registrar(Pessoa pessoa) {
		return pessoaRepository.saveAndFlush(pessoa);
	}
	
	@Transactional
	public void remover(Long pessoaId) {
		try {
			pessoaRepository.deleteById(pessoaId);
			pessoaRepository.flush();		
		}catch (EmptyResultDataAccessException e) {
			throw new RuntimeException();
		}
	}
}
