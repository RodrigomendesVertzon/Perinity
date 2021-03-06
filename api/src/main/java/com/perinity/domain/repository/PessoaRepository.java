package com.perinity.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perinity.domain.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	List<?> findAllByNome(@Param("nome") String nome);
	
	Pessoa findByNome(@Param("nome") String nome);
	
	List<Pessoa> findAllByIdDepartamento(int id);
}
