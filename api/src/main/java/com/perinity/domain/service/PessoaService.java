package com.perinity.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.perinity.domain.exceptions.EntidadeEmUsoException;
import com.perinity.domain.exceptions.EntidadeNaoEncontradaException;
import com.perinity.domain.exceptions.RegraDeNegocioException;
import com.perinity.domain.model.Pessoa;
import com.perinity.domain.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@Transactional
	public Pessoa registrar(Pessoa pessoa) {
		
		if(StringUtils.isEmpty(pessoa.getNome())) {
			throw new RegraDeNegocioException("O nome deve ser informado.");
		}
		if(StringUtils.isEmpty(pessoa.getIdDepartamento())) {
			throw new RegraDeNegocioException("o idDepartamento deve ser informado.");
		}
		
		return pessoaRepository.saveAndFlush(pessoa);
	}
	
	@Transactional
	public void remover(Integer pessoaId) {
		try {
			pessoaRepository.deleteById(pessoaId);
			pessoaRepository.flush();		
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Entidade não encontrada.");
		
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Entidade não pode ser excluída pois está em uso.");
		}
	}
}
